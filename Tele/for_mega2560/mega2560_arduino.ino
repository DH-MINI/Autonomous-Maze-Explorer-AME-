// Import the Servo library
#include <Servo.h>

// Define the pins for the ultrasonic sensor
#define TRIG_PIN_FRONT 26
#define ECHO_PIN_FRONT 28
#define TRIG_PIN_RIGHT 34
#define ECHO_PIN_RIGHT 36
#define TRIG_PIN_LEFT 30
#define ECHO_PIN_LEFT 32
#define TRIG_PIN_HEAD 22
#define ECHO_PIN_HEAD 24

// Define the pins for the LED light
#define redPin 23
#define bluePin 25
#define greenPin 27

// Define the pins for the color sensor
#define S0 2
#define S1 3
#define S2 4
#define S3 5
#define Out 6

// Define the pins for the button and LED light
#define BUTTON_PIN 50
#define LED_PIN 13

// Define the pins for the motor drive module
#define IN1 9
#define IN2 12
#define IN3 11
#define IN4 10

// Define parameters such as minimum distance and movement time
#define MIN_DISTANCE 15
#define MIN_DISTANCE_2 10
#define MOVE_TIME 200
#define STOP_TIME 50

// Speed of sound, used to calculate distance readings from the ultrasonic sensor
#define SOUND_SPEED 0.034

// Create Servo objects to control servos
Servo myservo_1;
Servo myservo_2;

// Other global variables, used to store state information and other data
int angle = 0;
int count = 0;
bool start_end = false;
bool running = false;
unsigned long myTime;
int redFrequency = 0;
int greenFrequency = 0;
int blueFrequency = 0;

void setup() {
  // Initialize serial communication, set baud rate to 9600bps, and print a message indicating that the Bluetooth module is ready.
  Serial.begin(9600);
  // Serial.println("Serial is ready!");

  // Connect the servos to the specified pins
  myservo_1.attach(7);  // The servo on top
  myservo_2.attach(8);  // The servo at the bottom

  // Wait for 2.5 seconds to ensure all devices are ready
  delay(2500);

  // Set button pin as input mode
  pinMode(BUTTON_PIN, INPUT);

  // Set pin modes for ultrasonic sensor
  pinMode(TRIG_PIN_FRONT, OUTPUT);
  pinMode(ECHO_PIN_FRONT, INPUT);
  pinMode(TRIG_PIN_LEFT, OUTPUT);
  pinMode(ECHO_PIN_LEFT, INPUT);
  pinMode(TRIG_PIN_RIGHT, OUTPUT);
  pinMode(ECHO_PIN_RIGHT, INPUT);
  pinMode(TRIG_PIN_HEAD, OUTPUT);
  pinMode(ECHO_PIN_HEAD, INPUT);

  // Set pin mode for LED light
  pinMode(LED_PIN, OUTPUT);

  // Set pin modes for motor drive module
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);

  // Set pin modes for color sensor and set S0 and S1 to high and low levels respectively to set the output frequency of the color sensor
  pinMode(S0, OUTPUT);
  pinMode(S1, OUTPUT);
  pinMode(S2, OUTPUT);
  pinMode(S3, OUTPUT);
  pinMode(Out, INPUT);

  // Set pin modes for LED light as output
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);

  // Set frequency scaling of color sensor to 20%
  digitalWrite(S0, HIGH);
  digitalWrite(S1, LOW);
}

void loop() {
  // Check button status. If button is pressed, toggle running state and send start or end message via Bluetooth
  int buttonState = digitalRead(BUTTON_PIN);

  if (buttonState == LOW) {
    running = !running;
    Serial.println(running ? "Start." : "End.");
    delay(500);
  }

  // If robot is running, get distance readings from ultrasonic sensor and decide robot's action based on readings
  if (running) {

    float distance_front = get_distance_front();
    float distance_left = get_distance_left();
    float distance_right = get_distance_right();
    float distance_head = get_distance_head();

    int fr_cango = (distance_front > MIN_DISTANCE);
    int ri_cango = (distance_right > MIN_DISTANCE_2);
    int le_cango = (distance_left > MIN_DISTANCE_2);

    if (distance_head < 8 && distance_head > 1) {
      digitalWrite(LED_PIN, HIGH);
      find_color();
      Serial.println("Find");
      delay(8000);

      turnBack();
      delay(MOVE_TIME);
      stop();
      delay(STOP_TIME);

      servo_turn();
      delay(2000);
      digitalWrite(LED_PIN, LOW);
      delay(2000);

      turn_180();
    } else {
      action_choose(fr_cango, ri_cango, le_cango, distance_right, distance_left);
    }
  }
}

// Based on the distance readings from the ultrasonic sensor, choose the action of the robot
void action_choose(int fr_cango, int ri_cango, int le_cango, float distance_right, float distance_left) {
  // If it is possible to move forward on the front, left and right, then move forward
  if (fr_cango && ri_cango && le_cango) {
    forward();
    delay(MOVE_TIME);
    stop();
    delay(STOP_TIME);
    Serial.println("Forward");
  } else {

    // If it is not possible to move forward on the right but possible on the left, then turn left
    if (!ri_cango && le_cango) {
      if (!fr_cango) {
        turnBack();
        delay(MOVE_TIME);
        stop();
        delay(STOP_TIME);
        Serial.println("Back");
      }
      turnLeft();
      delay(MOVE_TIME);
      stop();
      delay(STOP_TIME);
      Serial.println("Left");
    }

    // If it is not possible to move forward on the left but possible on the right, then turn right
    if (ri_cango && !le_cango) {
      if (!fr_cango) {
        turnBack();
        delay(MOVE_TIME);
        stop();
        delay(STOP_TIME);
      }
      turnRight();
      delay(MOVE_TIME);
      stop();
      delay(STOP_TIME);
      Serial.println("Right");
    }
  }
}

// Function to turn 180 degrees
void turn_180() {
  turnRight();
  delay(MOVE_TIME * 4);
  stop();
  delay(STOP_TIME);
  turnBack();
  delay(MOVE_TIME);
  turnRight();
  delay(MOVE_TIME * 4);
  stop();
  delay(STOP_TIME);
}

// Estimate color based on color and light up LED
void color(unsigned char red, unsigned char green, unsigned char blue) {
  int min = 9999;
  int min_color;
  if (red < min) {
    min = red;
    min_color = 1;
  }
  if (green < min) {
    min = green;
    min_color = 0;
  }
  if (blue < min) {
    min = blue;
    min_color = 2;
  }

  switch (min_color) {
    case 1:
      analogWrite(redPin, 255);
      analogWrite(bluePin, 0);
      analogWrite(greenPin, 0);
      break;
    case 2:
      analogWrite(redPin, 0);
      analogWrite(bluePin, 255);
      analogWrite(greenPin, 0);
      break;
    case 0:
      analogWrite(redPin, 0);
      analogWrite(bluePin, 0);
      analogWrite(greenPin, 255);
      break;
  }
}

// Get the approximate color of the object
void find_color() {
  digitalWrite(S2, LOW);
  digitalWrite(S3, LOW);

  redFrequency = pulseIn(Out, LOW);
  delay(100);

  digitalWrite(S2, HIGH);
  digitalWrite(S3, HIGH);
  greenFrequency = pulseIn(Out, LOW);
  delay(100);

  digitalWrite(S2, LOW);
  digitalWrite(S3, HIGH);
  blueFrequency = pulseIn(Out, LOW);
  delay(100);

  Serial.print("Find:Red: ");
  Serial.print(redFrequency);
  Serial.print(" Green: ");
  Serial.print(greenFrequency);
  Serial.print(" Blue: ");
  Serial.println(blueFrequency);

  color(255 - redFrequency, 255 - greenFrequency, 255 - blueFrequency);
  delay(1000);
}

// Control servo movement based on two parameters
void smooth_servo_turn(Servo &servo, int start_angle, int end_angle) {
  int step = start_angle < end_angle ? 1 : -1;

  for (angle = start_angle; angle != end_angle; angle += step) {
    servo.write(angle);
    delay(30);
  }
}

// Servo movement scheme
void servo_turn() {
  smooth_servo_turn(myservo_2, 90, 135);  // Turn the bottom servo
  delay(1000);                            // Wait for a second
  smooth_servo_turn(myservo_1, 90, 45);   // Turn the top servo
  smooth_servo_turn(myservo_1, 45, 90);   // Turn the top servo back

  smooth_servo_turn(myservo_2, 135, 90);  // Turn the bottom servo back
  delay(1000);                            // Wait for a second
  smooth_servo_turn(myservo_1, 45, 90);   // Turn the top servo back

  smooth_servo_turn(myservo_2, 90, 45);  // Turn the bottom servo
  delay(1000);                           // Wait for a second
  smooth_servo_turn(myservo_1, 90, 45);  // Turn the top servo
  smooth_servo_turn(myservo_1, 45, 90);  // Turn the top servo back

  smooth_servo_turn(myservo_2, 45, 90);  // Turn the bottom servo back
  delay(3000);                           // Wait for three seconds
}
