🏃 Endless Runner Game
https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white
https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white
https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white

A futuristic endless runner game with Bluetooth hardware controller support

📱 Features
🎮 Dual Control - Touch screen + Bluetooth hardware (ESP32/Arduino)

🎨 Cyberpunk UI - Neon glows, glass morphism, smooth animations

⚡ Dynamic Difficulty - Speed increases with your score

🏆 High Score - Track your best performance

📡 Real-time Bluetooth - See hardware commands instantly

🔄 3 Control Modes - Touch only, Hardware only, or Both

🛠️ Tech Stack
Language: Kotlin

UI: Jetpack Compose

Bluetooth: Android Bluetooth API

Concurrency: Coroutines

Minimum SDK: Android 6.0 (API 23)

🚀 Quick Start
1. Clone & Open
bash
git clone https://github.com/jeren-dev/endless-runner.git
cd endless-runner
Open in Android Studio and click Run ▶️

2. Hardware Setup (Optional)
ESP32/Arduino Code:

cpp
#include <SoftwareSerial.h>

SoftwareSerial bluetooth(10, 11); // RX, TX

void setup() {
  bluetooth.begin(9600);
  pinMode(2, INPUT_PULLUP); // Left button
  pinMode(3, INPUT_PULLUP); // Right button
}

void loop() {
  if(digitalRead(2) == LOW) {
    bluetooth.println("L");
    delay(200);
  }
  if(digitalRead(3) == LOW) {
    bluetooth.println("R");
    delay(200);
  }
}
Circuit:

text
HC-05/06 → ESP32
VCC → 3.3V
GND → GND
TX → RX (pin 10)
RX → TX (pin 11)

Buttons:
Left → Pin 2
Right → Pin 3
3. Update MAC Address
kotlin
// In MainActivity.kt
private val ESP32_MAC = "20:E7:C8:9E:4E:76" // 🔥 Replace with your ESP32 MAC
🎮 How to Play
Start: Tap the glowing play button

Move: Swipe or use arrow buttons / hardware controller

Dodge: Avoid obstacles in 3 lanes

Score: Higher score = faster speed

Restart: Game over → restart or main menu

Control Modes
Mode	Touch	Hardware
Touch	✅	❌
Hardware	❌	✅
Both	✅	✅
📱 Permissions
The app requires these permissions (requested at runtime):

Bluetooth Connect & Scan

Location (for Bluetooth scanning)

🐛 Troubleshooting
Issue	Fix
Can't connect to ESP32	Check MAC address & Bluetooth is ON
No data received	Verify baud rate (9600) & wiring
App crashes	Clear cache & restart
Laggy gameplay	Close background apps
📁 Project Structure
text
app/src/main/java/com/example/endlessrunner/
├── MainActivity.kt       # Main game + Bluetooth
├── Game Logic           # Obstacles, particles, collision
└── UI Components        # Buttons, cards, animations
📝 License
MIT License - Free to use, modify, and distribute

👨‍💻 Author
Jeren Dev

GitHub: @jeren-dev

⭐ Show Your Support
If you like this project, please give it a ⭐ on GitHub!

Made with ❤️ and Kotlin

Quick Copy for GitHub
Just copy this entire block and paste it as README.md in your repository:

markdown
# 🏃 Endless Runner Game

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)

> A futuristic endless runner game with Bluetooth hardware controller support

## 📱 Features

- 🎮 **Dual Control** - Touch screen + Bluetooth hardware (ESP32/Arduino)
- 🎨 **Cyberpunk UI** - Neon glows, glass morphism, smooth animations
- ⚡ **Dynamic Difficulty** - Speed increases with your score
- 🏆 **High Score** - Track your best performance
- 📡 **Real-time Bluetooth** - See hardware commands instantly
- 🔄 **3 Control Modes** - Touch only, Hardware only, or Both

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Bluetooth**: Android Bluetooth API
- **Concurrency**: Coroutines
- **Minimum SDK**: Android 6.0 (API 23)

## 🚀 Quick Start

### 1. Clone & Open
```bash
git clone https://github.com/jeren-dev/endless-runner.git
cd endless-runner
Open in Android Studio and click Run ▶️

2. Hardware Setup (Optional)
ESP32/Arduino Code:

cpp
#include <SoftwareSerial.h>

SoftwareSerial bluetooth(10, 11); // RX, TX

void setup() {
  bluetooth.begin(9600);
  pinMode(2, INPUT_PULLUP); // Left button
  pinMode(3, INPUT_PULLUP); // Right button
}

void loop() {
  if(digitalRead(2) == LOW) {
    bluetooth.println("L");
    delay(200);
  }
  if(digitalRead(3) == LOW) {
    bluetooth.println("R");
    delay(200);
  }
}
Circuit:

text
HC-05/06 → ESP32
VCC → 3.3V
GND → GND
TX → RX (pin 10)
RX → TX (pin 11)

Buttons:
Left → Pin 2
Right → Pin 3
3. Update MAC Address
kotlin
// In MainActivity.kt
private val ESP32_MAC = "20:E7:C8:9E:4E:76" // 🔥 Replace with your ESP32 MAC
🎮 How to Play
Start: Tap the glowing play button

Move: Swipe or use arrow buttons / hardware controller

Dodge: Avoid obstacles in 3 lanes

Score: Higher score = faster speed

Restart: Game over → restart or main menu

Control Modes
Mode	Touch	Hardware
Touch	✅	❌
Hardware	❌	✅
Both	✅	✅
📱 Permissions
The app requires these permissions (requested at runtime):

Bluetooth Connect & Scan

Location (for Bluetooth scanning)

🐛 Troubleshooting
Issue	Fix
Can't connect to ESP32	Check MAC address & Bluetooth is ON
No data received	Verify baud rate (9600) & wiring
App crashes	Clear cache & restart
Laggy gameplay	Close background apps
📁 Project Structure
text
app/src/main/java/com/example/endlessrunner/
├── MainActivity.kt       # Main game + Bluetooth
├── Game Logic           # Obstacles, particles, collision
└── UI Components        # Buttons, cards, animations
📝 License
MIT License - Free to use, modify, and distribute

👨‍💻 Author
Jeren Dev

GitHub: @jeren-dev

⭐ Show Your Support
If you like this project, please give it a ⭐ on GitHub!

