# 🚀Android App - Quote Finder

Hello Star,

An Android app built using Kotlin + XML.  
This repository contains the source code and a downloadable APK.

- Important Note:
  App is still in beta version. When user luanch app first time, He/She has to click New Quote button.
  It will load the quotes in local storage.
  Whenever user want new quote, same button gives you functionallity. It will load new quote but liked & stared one quote stays there.

---

- Features :
    - 🔄 Fetch Quotes – Get new quotes from the API Ninjas Quotes API.
    - ⭐ Save Favorites – Mark quotes with a star.
    - ❤️ Save Loved Quotes – Mark quotes with a heart.
    - 📂 Manage Saved Quotes – View lists of starred, hearted, or both-starred-and-hearted quotes.
    - 📶 API Integration – Uses Retrofit to connect with API Ninjas.

---

## 📱 Download APK:
https://github.com/SavantYash/Quote-Finder/releases/download/v1.0.0/app-debug.apk

After downloading, install the APK on your Android phone.  
(You may need to enable **"Install from unknown sources"** in settings.)

---

- Architecture :
  - UI : XML
  - Language : Kotlin
  - Pattern : MVVM
  - Permission : Internet ( require first time and whenever user want new quotes )
  - Persistence : Room Database
  - 3rd party API : APIs Ninja
  - Libraries : Retrofit, Corutines, GSon Convertor

---

- Description : 
  1) The app shows number of quotes by which user can save the favorite one.
  2) App gave feature to save quote by either adding star or heart or both.
  3) App has one more button to request for new quotes.
  4) The saved quotes not going anywhere until user unsaved it.
