<template>
          <!-- Main Content -->
      <div class="main-content" style="min-height: 517px;">
        <section class="section">
          <div class="section-header">
            <h1>下载和教程</h1>
          </div>
          <div class="section-body">
            <div class="row mt-sm-4">
              <div class="col-lg-6 windows-card">
                                <div class="card card-hero"  @click="toWindow(1)">
                                  <div class="card-header os-card windows-card">
                    <div class="card-icon">
                      <i class="fab fa-windows"></i>
                    </div>
                    <h4>Windows</h4>
                    <div class="card-description">适用于 Windows 7 或更高版本
                        <svg t="1610700084144" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10132" width="64" height="64"><path d="M456 484V160.1l-335.9 72V484H456zM512 484h391.8V64.2l-391.8 84V484zM456 540H120.2v251.9l335.9 72V540zM512 540v335.9l391.8 84V540H512z" fill="#00adef" p-id="10133"></path></svg>
                    </div>
                 
                  </div>
                </div>
              </div>
              <div class="col-lg-6 android-card">
                                <div class="card card-hero" @click="toAndroid(1)">
                                  <div class="card-header os-card android-card">
                    <div class="card-icon">
                      <i class="fab fa-android"></i>
                    </div>
                    <h4>Android</h4>
                    <div class="card-description">适用于 Android 5.0 或更高版本
                        <svg t="1610700286605" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10936" width="64" height="64"><path d="M633.639322 204.310541a20.138113 20.138113 0 0 1-20.052782-20.266109 20.095447 20.095447 0 1 1 40.105563 0c0 11.178359-8.959754 20.266109-20.052781 20.266109z m-243.79063 0a20.138113 20.138113 0 0 1-20.052781-20.266109 20.095447 20.095447 0 1 1 40.105563 0c0 11.178359-8.959754 20.266109-20.052782 20.266109z m252.110401-117.756761c79.9978 39.550912 134.140311 114.471519 134.140311 200.186495H247.900596c0-85.757642 54.185177-160.635583 134.225642-200.186495l-10.623708-16.895536-10.538377-16.639542-23.466021-37.460303A10.41038 10.41038 0 0 1 340.058062 1.734779a9.173081 9.173081 0 0 1 13.140972 2.773257l25.172641 40.105564 10.666373 16.85287 10.666373 17.108863A294.818559 294.818559 0 0 1 512 56.773265c40.105564 0 78.120518 7.807785 112.210248 21.844733l10.794369-17.108863 35.88168-56.958433a8.959754 8.959754 0 0 1 13.012976-2.773258c4.35188 2.986585 5.546514 9.215747 2.64526 13.82362l-23.508686 37.460303-10.538377 16.639543-10.538377 16.895535zM251.953818 327.699148H776.099404v433.566744c0 34.388388-26.708599 62.419617-59.731691 62.419617H673.275565c1.493292 5.20519 2.346602 10.666373 2.346602 16.426215v124.796568c0 32.639102-25.385969 59.091708-56.702441 59.091708-31.231141 0-56.531779-26.452606-56.531778-59.091708V840.111724c0-5.759842 0.767979-11.221025 2.218605-16.426215h-105.127775c1.450627 5.20519 2.303937 10.666373 2.303936 16.426215v124.796568c0 32.639102-25.385969 59.091708-56.617109 59.091708-31.273807 0-56.659775-26.452606-56.659776-59.091708V840.111724c0-5.759842 0.810644-11.221025 2.303937-16.426215h-43.092148c-33.023092 0-59.774356-28.031229-59.774356-62.419617V327.699148h4.053221z m-105.639762 0c33.663074 0 60.926325 26.281944 60.926325 58.707719v251.214425c0 32.425775-27.305916 58.707719-60.926325 58.707719-33.70574 0-60.96899-26.281944-60.96899-58.707719V386.406867c0-32.425775 27.305916-58.707719 61.011656-58.707719z m731.414553 0c33.663074 0 60.926325 26.281944 60.926325 58.707719v251.214425c0 32.425775-27.305916 58.707719-60.926325 58.707719-33.70574 0-61.011656-26.281944-61.011655-58.707719V386.406867c0-32.425775 27.305916-58.707719 61.011655-58.707719z" fill="#A4C639" p-id="10937"></path></svg>
                    </div>
 
                  </div>
                </div>
              </div>
              <div class="col-lg-6 apple-card">
                                <div class="card card-hero"  @click="toApple(1)">
                                  <div class="card-header os-card ios-card">
                    <div class="card-icon">
                      <i class="fab fa-apple"></i>
                    </div>
                    <h4>Apple</h4>
                    <div class="card-description">适用于 iOS 9 或更高版本
                        <svg t="1610700353448" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11794" width="64" height="64"><path d="M905.714286 694.285714q-22.285714 71.428571-70.285715 142.857143-73.714286 112-146.857142 112-28 0-80-18.285714-49.142857-18.285714-86.285715-18.285714-34.857143 0-81.142857 18.857142-46.285714 19.428571-75.428571 19.428572-86.857143 0-172-148Q109.714286 653.714286 109.714286 515.428571q0-130.285714 64.571428-213.714285 64.571429-82.285714 162.285715-82.285715 41.142857 0 101.142857 17.142858 59.428571 17.142857 78.857143 17.142857 25.714286 0 81.714285-19.428572 58.285714-19.428571 98.857143-19.428571 68 0 121.714286 37.142857 29.714286 20.571429 59.428571 57.142857-45.142857 38.285714-65.142857 67.428572-37.142857 53.714286-37.142857 118.285714 0 70.857143 39.428571 127.428571t90.285715 72zM690.857143 24q0 34.857143-16.571429 77.714286-17.142857 42.857143-53.142857 78.857143-30.857143 30.857143-61.714286 41.142857-21.142857 6.285714-59.428571 9.714285 1.714286-85.142857 44.571429-146.857142Q586.857143 23.428571 687.428571 0q0.571429 1.714286 1.428572 6.285714t1.428571 6.285715q0 2.285714 0.285715 5.714285t0.285714 5.714286z" p-id="11795"></path></svg>
                    </div>
                  
                  </div>
                </div>
              </div>
              <div class="col-lg-6 mac-card">
                                <div class="card card-hero"  @click="toMac(1)">
                                  <div class="card-header os-card mac-card">
                    <div class="card-icon">
                      <i class="fas malio-finder"></i>
                    </div>
                    <h4>Mac</h4>
                    <div class="card-description">适用于 macOS Sierra (10.12) 或更高版本
                  <svg t="1610700595855" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="15505" width="64" height="64"><path d="M960 108.8c35.2 0 64 28.8 64 64v518.4c0 35.2-28.8 64-64 64H646.4l57.6 115.2c6.4 16 0 35.2-12.8 41.6-3.2 3.2-9.6 3.2-12.8 3.2H348.8c-19.2 0-32-12.8-32-32 0-6.4 0-9.6 3.2-12.8l57.6-115.2H64c-35.2 0-64-28.8-64-64V172.8c0-35.2 28.8-64 64-64h896zM598.4 294.4c-35.2-3.2-67.2 19.2-86.4 19.2-16 0-41.6-19.2-70.4-19.2-35.2 0-70.4 22.4-89.6 54.4-38.4 64-9.6 163.2 25.6 217.6l6.4 9.6c16 22.4 35.2 48 60.8 44.8 28.8 0 38.4-19.2 70.4-19.2 32 0 41.6 19.2 70.4 16 28.8 0 48-25.6 67.2-54.4s28.8-60.8 28.8-60.8h-3.2C665.6 496 624 473.6 624 416c0-54.4 44.8-80 48-83.2-19.2-32-57.6-38.4-73.6-38.4z m0-105.6c-22.4 0-48 16-64 32-12.8 16-25.6 41.6-22.4 67.2 25.6 0 48-12.8 64-32 12.8-16 25.6-41.6 22.4-67.2z" fill="#888888" p-id="15506"></path></svg>
                    </div>
                  
                  </div>
                </div>
              </div>
              <div class="col-lg-6 linux-card">
                                <div class="card card-hero"  @click="toLinux(1)">
                                   
                                  <div class="card-header os-card linux-card">
                    <div class="card-icon">
                      <i class="fab fa-linux"></i>
                    </div>
                    <h4>Linux</h4>
                    <div class="card-description">适用于……所有版本？
<svg t="1610697511244" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9279" width="64" height="64"><path d="M525.2 198.3c-8.6 5.6-15.2 13.8-18.9 23.4-3.8 12.4-3.2 25.6 1.5 37.7 3.9 12.7 11.7 23.8 22.2 31.8 5.4 3.8 11.6 6.2 18.2 7 6.6 0.8 13.2-0.3 19.1-3.3 7-3.9 12.6-10 15.9-17.3 3.2-7.4 5-15.3 5.2-23.3 0.7-10.2-0.6-20.4-3.8-30.1-3.5-10.6-10.3-19.7-19.5-25.9-4.7-3-9.9-5-15.4-5.8-5.5-0.8-11.1-0.2-16.3 1.8-2.9 1.2-5.7 2.7-8.3 4.5" fill="#FFFFFF" p-id="9280"></path><path d="M810.2 606.5c-5.1-28.3-13.1-56-23.8-82.6-7.3-19.8-17.2-38.6-29.5-55.8-12.4-16.5-28.1-30.4-40.2-47.1-6.4-8.7-11.8-18.4-18.5-26.9-2.7-5.6-5.3-11.2-7.9-16.8-8-17.5-15.3-35.4-24.8-52-1.5-2.6-3.1-5.2-4.6-7.7-1.2-16-2.9-32-3.8-48 0.7-32.1-2-64.3-8.1-95.9-4.2-15.1-10.6-29.6-19-42.8-9.8-15.6-22.4-29.2-37.2-40.1-24.1-17.1-52.9-26.3-82.4-26.4-21.7-0.5-43.2 4.4-62.5 14.4-20.3 11.1-36.7 28.2-47 48.9-9.6 20.9-14.7 43.5-15 66.5-0.8 22.6 1.3 45 2.2 67.6 0.9 23.4 0.4 46.9 2.3 70.3 0.6 7.5 1.5 15 1.5 22.6 0 3.8-0.2 7.6-0.3 11.3l-0.3 0.8c-10.2 17.3-21.5 34-33.8 49.9-8.6 10.9-17.2 21.7-25.9 32.4-11.3 12.7-20.9 26.8-28.5 42-5.1 13.2-9.2 26.8-12.4 40.6l-0.3 1.1c-4.8 15.9-10.8 31.3-18 46.2-0.7 1.4-1.4 2.9-2 4.2-4.3 8.9-8.8 17.8-13.5 26.5l-5.4 10.1c-3.4 6.1-6.4 12.4-9 18.8-1.5 3.9-2.7 7.9-3.4 12-1.3 8.7-0.7 17.5 1.6 25.9 0.5 2.1 1.2 4.2 1.9 6.3 2.2 6.2 4.8 12.3 7.9 18.1 1.4 2.7 2.9 5.3 4.3 8l1.3 1.9c1.4 2.5 2.9 5 4.4 7.4l0.2 0.3c1.7 2.8 3.6 5.5 5.4 8.2l0.3 0.4c1.9 2.6 3.8 5.3 5.8 7.9 7.4 28.9 21 55.8 39.7 79-2.9 5.1-5.5 10.1-8.4 15.1-10.2 14.8-18.6 30.7-25.1 47.4-2.7 8.6-3.4 17.7-1.9 26.6 1.4 9 6 17.1 13 23 4.7 3.6 10.1 6.1 15.8 7.3 5.7 1.2 11.6 1.8 17.5 1.5 22.2-1.7 44.2-6.1 65.4-12.9 12.8-3.4 25.6-6.4 38.6-9 13.5-3.1 27.2-5 41-5.6 3.4 0.1 6.8-0.1 10.1-0.3 9.4 1 18.8 1.4 28.3 1l3.5-0.2c2.4 0.3 4.9 0.4 7.4 0.6 16.6 0.9 33.1 2.6 49.5 5.1 14.4 2.2 28.8 5 43 8.5 21.9 6.6 44.4 11 67.3 12.9 6 0.3 12-0.2 18-1.4 5.9-1.2 11.5-3.8 16.3-7.4 7-5.8 11.6-13.9 13.1-22.9 1.5-8.9 0.8-18-1.9-26.6-6.6-16.7-15.1-32.6-25.5-47.3-3.6-6.1-7-12.4-10.6-18.5 15.5-17.3 29.2-36.3 40.7-56.5 7 0.4 13.9-0.4 20.6-2.6 17.5-5.9 32.7-17.3 43.3-32.5 3.2-4.5 5.7-9.5 7.2-14.8 6.9-10.7 11.6-22.7 13.8-35.3 3.2-20.8 2.7-42.1-1.5-62.7h-0.2z m0 0" fill="#020204" p-id="9281"></path><path d="M425.6 323.2c-3.1 4-5.3 8.7-6.4 13.6-1.1 4.9-1.8 10-1.9 15 0.3 10.1-0.5 20.2-2.5 30.1-3.5 10.3-8.8 19.8-15.6 28.3-11.7 14.7-20.9 31.2-27.2 48.8-3.2 10.9-4.3 22.3-3.1 33.7-12.1 17.9-22.6 36.9-31.3 56.7-13.4 29.9-22 61.8-25.5 94.4-4.3 40.1 1.6 80.6 17 117.8 11.3 26.8 28.5 50.8 50.3 70.1 11.2 9.7 23.5 17.9 36.7 24.4 46.7 22.8 101.4 22.3 147.6-1.4 23.1-13.5 44.2-30.2 62.6-49.5 11.9-10.8 22.5-22.9 31.8-36.1 15.5-26.9 24.6-57.1 26.5-88.1 9.6-53.6 3.7-108.8-16.9-159.2-8.1-16.8-18.8-32.2-31.8-45.6a252.5 252.5 0 0 0-20.2-68c-7.2-15.5-15.9-30.3-22.6-46.2-2.7-6.5-5.1-13.1-8.1-19.4-2.9-6.4-6.9-12.3-11.8-17.3-5.3-4.9-11.6-8.6-18.5-10.7-6.9-2.2-14-3.4-21.2-3.6-14.4-0.7-28.9 1.1-43.1 0.6-11.5-0.5-22.8-2.5-34.3-1.8-5.7 0.3-11.4 1.4-16.7 3.5-5.4 2.1-10.1 5.5-13.8 10m4.6-125.1c-5.4 0.4-10.5 2.7-14.4 6.4-3.9 3.7-6.8 8.4-8.4 13.5-2.7 10.4-3.4 21.3-1.9 32 0.2 9.7 1.9 19.4 5.1 28.6 1.8 4.5 4.4 8.7 7.8 12.2 3.4 3.5 7.7 6.1 12.4 7.3 4.5 1.1 9.2 0.9 13.5-0.5 4.3-1.4 8.3-3.8 11.5-7 4.7-4.8 8.1-10.7 9.8-17.1 1.7-6.4 2.5-13.1 2.3-19.8 0-8.3-1.3-16.6-3.8-24.6s-6.8-15.3-12.6-21.4c-2.8-2.9-6-5.4-9.6-7.2-3.7-1.7-7.7-2.6-11.7-2.4m95 0c-8.6 5.6-15.2 13.8-18.9 23.4-3.8 12.4-3.2 25.6 1.5 37.7 3.9 12.7 11.7 23.8 22.2 31.8 5.4 3.8 11.6 6.2 18.2 7 6.6 0.8 13.2-0.3 19.1-3.3 7-3.9 12.6-10 15.9-17.3 3.2-7.4 5-15.3 5.2-23.3 0.7-10.2-0.6-20.4-3.8-30.1-3.5-10.6-10.3-19.7-19.5-25.9-4.7-3-9.9-5-15.4-5.8-5.5-0.8-11.1-0.2-16.3 1.8-2.9 1.2-5.7 2.7-8.3 4.5" fill="#FFFFFF" p-id="9282"></path><path d="M544.5 223.6c-3.2 0.2-6.2 1.2-8.9 2.9s-5 4-6.8 6.6c-3.4 5.3-5.3 11.5-5.4 17.9-0.3 4.7 0.4 9.5 1.9 14s4.3 8.5 7.9 11.5c3.8 3.1 8.4 4.9 13.3 5.2 4.9 0.2 9.7-1.1 13.7-3.9 3.2-2.3 5.8-5.2 7.6-8.7 1.8-3.4 2.9-7.2 3.4-11 1-6.8-0.2-13.8-3.2-19.9-3.1-6.2-8.4-10.9-14.8-13.4-2.8-1.1-5.7-1.5-8.7-1.4" fill="#020204" p-id="9283"></path><path d="M430.2 198.3c-5.4 0.4-10.5 2.7-14.4 6.4-3.9 3.7-6.8 8.4-8.4 13.5-2.7 10.4-3.4 21.3-1.9 32 0.2 9.7 1.9 19.4 5.1 28.6 1.8 4.6 4.4 8.7 7.8 12.2 3.4 3.5 7.7 6.1 12.4 7.3 4.5 1.1 9.2 0.9 13.5-0.5 4.3-1.4 8.3-3.8 11.5-7 4.7-4.8 8.1-10.7 9.8-17.1 1.7-6.4 2.5-13.1 2.3-19.8 0-8.3-1.3-16.6-3.8-24.6s-6.8-15.3-12.6-21.4c-2.8-2.9-6-5.4-9.6-7.2-3.7-1.7-7.7-2.6-11.7-2.4" fill="#FFFFFF" p-id="9284"></path><path d="M417.3 242.8c-1.3 6.7-1 13.7 1.1 20.2 1.6 4.3 4 8.2 7.2 11.5 2 2.2 4.3 4.1 7 5.4 2.7 1.4 5.7 1.8 8.7 1.1 2.7-0.7 5-2.3 6.7-4.5 1.7-2.2 2.9-4.7 3.7-7.3 2.3-7.8 2.1-16.1-0.4-23.9-1.6-5.7-4.7-10.9-9.1-14.8-2.1-1.8-4.7-3.2-7.4-3.9-2.8-0.7-5.7-0.5-8.4 0.7-2.8 1.4-5.1 3.7-6.5 6.5-1.4 2.8-2.3 5.8-2.7 8.9" fill="#020204" p-id="9285"></path><path d="M404.6 326.9c0.2 0.9 0.5 1.8 1 2.5 0.9 1.4 2 2.5 3.4 3.4 1.3 0.9 2.6 1.7 3.9 2.5 6.9 4.7 13 10.5 17.9 17.3 6 9.4 13.5 17.8 22 25 6.5 4.5 14.1 7.2 22 7.9 9.2 0.7 18.5-0.4 27.4-3.2 8.2-2.4 16.1-5.8 23.5-10.3 12.7-10.2 26.3-19.2 40.7-26.7 3.4-1.2 6.8-2.1 10-3.6 3.3-1.4 6.1-3.8 7.8-7 1.1-3.2 1.8-6.6 1.9-10 0.5-3.6 1.7-7.1 2.3-10.7 0.8-3.6 0.5-7.3-0.8-10.8-1.4-2.7-3.6-4.9-6.3-6.3-2.7-1.3-5.7-2.1-8.7-2.2-6.1 0.2-12.1 0.8-18 1.8-8 0.7-16-0.3-24 0-9.9 0.3-19.8 2.5-29.8 2.9-11.4 0.6-22.7-1.2-34.1-1.7-4.9-0.3-9.9-0.1-14.8 0.7-4.9 0.7-9.6 2.5-13.7 5.3-3.8 3-7.3 6.2-10.7 9.6-1.8 1.6-3.8 3-5.9 4.1-2.2 1.1-4.5 1.7-7 1.6-1.2-0.2-2.5-0.2-3.7 0-0.7 0.3-1.4 0.7-1.9 1.2l-1.5 1.8c-1 1.5-1.9 3.1-2.6 4.7" fill="#D99A03" p-id="9286"></path><path d="M429.7 301.7c-4 2.4-7.9 5-11.8 7.7-2.1 1.3-3.8 3-5.1 5.1-0.7 1.6-1 3.3-0.9 5 0.1 1.7 0.1 3.4 0 5.1-0.1 1.1-0.5 2.3-0.5 3.5 0 0.6 0 1.2 0.2 1.7 0.2 0.6 0.4 1.1 0.8 1.5 0.5 0.5 1.2 0.9 2 1.1 0.7 0.2 1.5 0.3 2.3 0.5 3.5 1 6.7 2.9 9.3 5.4 2.7 2.4 5.1 5.2 8 7.5 8 6 17.7 9.1 27.6 9 9.9-0.2 19.7-1.6 29.2-4.1 7.5-1.6 14.9-3.6 22.1-6.1 11.2-4.2 21.5-10.3 30.4-18.2 3.9-3.8 8-7.2 12.4-10.3 4-2.5 8.7-4.2 12.7-6.6 0.4-0.2 0.7-0.5 1.1-0.7 0.3-0.3 0.6-0.6 0.8-1 0.3-0.7 0.3-1.5 0-2.2-0.2-0.7-0.5-1.3-0.9-1.8-0.5-0.6-1.1-1.2-1.7-1.7-4.6-3.4-10.1-5.3-15.8-5.5-5.8-0.4-11.3 0-16.9-1.1-5.2-1.1-10.3-2.6-15.3-4.4-5.3-1.7-10.7-3-16.3-3.9-13-2.1-26.2-1.8-39.1 1-12.1 2.7-23.8 7.3-34.6 13.5" fill="#604405" p-id="9287"></path><path d="M428.4 288.1c-5.8 3.9-11 8.7-15.5 14.1-2.6 3-4.7 6.5-6.1 10.3-0.9 3-1.5 6.1-2 9.2-0.3 1.1-0.5 2.3-0.5 3.5 0 0.6 0.1 1.2 0.3 1.7 0.2 0.6 0.5 1.1 0.9 1.5 0.7 0.7 1.6 1.1 2.6 1.3 0.9 0.2 1.9 0.2 2.9 0.3 4.4 0.7 8.5 2.5 12.1 5.1 3.6 2.5 7 5.4 10.7 7.8 8.4 5 18 7.7 27.8 7.9 9.8 0.2 19.5-0.8 29-2.9 7.6-1.4 15.1-3.5 22.4-6.3 10.9-4.7 21.1-10.8 30.4-18.2 4.3-3.2 8.5-6.6 12.4-10.3 1.3-1.3 2.6-2.6 4-3.8 1.4-1.2 3-2.1 4.7-2.7 2.7-0.7 5.5-0.8 8.3-0.1 2 0.5 4.1 0.7 6.2 0.7 1.1 0 2.1-0.2 3.1-0.5 1-0.4 1.9-1 2.5-1.8 0.9-1.1 1.3-2.4 1.3-3.8s-0.4-2.7-1.1-3.9c-1.5-2.3-3.8-4.1-6.3-5.1-3.5-1.4-7.1-2.5-10.8-3.2-11.3-2.7-22.3-6.7-32.7-11.9-5.2-2.6-10.1-5.4-15.3-8.1-5.2-2.9-10.6-5.4-16.2-7.2-12.9-3.5-26.6-2.9-39.1 1.8-14 4.9-26.5 13.4-36.1 24.7" fill="#F5BD0C" p-id="9288"></path><path d="M493.5 272.2c0.7 2.3 4.3 1.9 6.4 2.9 2.1 1 3.3 2.9 5.3 3.1 2.1 0.2 5-0.7 5.3-2.6 0.4-2.6-3.4-4.2-5.8-5.1-3.2-1.5-6.8-1.6-10-0.2-0.7 0.3-1.4 1.2-1.2 1.9z m-34.4-1.2c-2.7-0.9-7.1 3.8-5.8 6.3 0.4 0.7 1.6 1.5 2.4 1.1 0.8-0.4 2.3-3.1 3.6-4 1-0.8 0.8-3.1-0.2-3.4z m0 0" fill="#CD8907" p-id="9289"></path><path d="M887.7 829.8c-2 5.2-4.9 10-8.5 14.3-8.4 9-18.6 16.2-29.8 21.2-19 8.8-37.5 18.6-55.5 29.3-11.7 7.8-22.6 16.6-32.7 26.4-8.3 8.7-17.2 16.7-26.6 24.2-9.8 7.2-21.1 12.1-33.1 14-14.7 1.9-29.6-0.4-43.1-6.5-9.7-3.7-18.1-10.2-24-18.8-5-9.2-7.3-19.5-6.8-29.9 0.6-18.3 2.8-36.5 6.6-54.5 2.6-15 5.2-30 6.8-45.1 2.8-27.6 3.1-55.3 1-82.9-0.5-4.6-0.5-9.3 0-13.9 0.6-9.4 8.5-16.6 18-16.5 4.3-0.1 8.6 0.3 12.8 1.1 10 1.2 20 2.9 29.8 5.2 6.1 1.6 12.2 3.8 18.3 5.5 10.2 3 21 3.9 31.6 2.9 11.1-2.6 22.4-4.3 33.8-5.3 4.7 0.2 9.4 1 13.8 2.4 4.6 1.3 8.9 3.6 12.4 6.9 2.5 2.7 4.5 5.8 5.8 9.2 1.9 5.1 3.1 10.4 3.5 15.8 0.2 4.8 0.6 9.6 1.2 14.4 1.7 7.7 5.4 14.9 10.6 20.9 5.3 5.8 11 11.2 17.2 16 5.9 5.2 12.1 10 18.6 14.4 3.1 2.1 6.2 4 9.1 6.3 3 2.2 5.5 5 7.4 8.2 2.4 4.4 3.2 9.5 2 14.4" fill="#F5BD0C" p-id="9290"></path><path d="M887.7 829.8c-2 5.2-4.9 10-8.5 14.3-8.4 9-18.6 16.2-29.8 21.2-19 8.8-37.5 18.6-55.5 29.3-11.7 7.8-22.6 16.6-32.7 26.4-8.3 8.7-17.2 16.7-26.6 24.2-9.8 7.2-21.1 12.1-33.1 14-14.7 1.9-29.6-0.4-43.1-6.5-9.7-3.7-18.1-10.2-24-18.8-5-9.2-7.3-19.5-6.8-29.9 0.6-18.3 2.8-36.5 6.6-54.5 2.6-15 5.2-30 6.8-45.1 2.8-27.6 3.1-55.3 1-82.9-0.5-4.6-0.5-9.3 0-13.9 0.6-9.4 8.5-16.6 18-16.5 4.3-0.1 8.6 0.3 12.8 1.1 10 1.2 20 2.9 29.8 5.2 6.1 1.6 12.2 3.8 18.3 5.5 10.2 3 21 3.9 31.6 2.9 11.1-2.6 22.4-4.3 33.8-5.3 4.7 0.2 9.4 1 13.8 2.4 4.6 1.3 8.9 3.6 12.4 6.9 2.5 2.7 4.5 5.8 5.8 9.2 1.9 5.1 3.1 10.4 3.5 15.8 0.2 4.8 0.6 9.6 1.2 14.4 1.7 7.7 5.4 14.9 10.6 20.9 5.3 5.8 11 11.2 17.2 16 5.9 5.2 12.1 10 18.6 14.4 3.1 2.1 6.2 4 9.1 6.3 3 2.2 5.5 5 7.4 8.2 2.4 4.4 3.2 9.5 2 14.4M259.4 676.3c4.9-1.9 10.2-2.4 15.4-1.4 5.2 1 10.1 3.1 14.4 6.1 8.3 6.3 15.5 14.1 21.2 22.8 14.1 19.4 27.6 39.2 39.9 59.8 10 16.7 19.1 33.9 30.6 49.6 7.5 10.2 16 19.7 23.6 29.9 7.9 10 13.9 21.4 17.6 33.5 4.4 16.1 2.6 33.2-4.9 48.1-5.4 10.4-13.5 19.1-23.4 25.1-10 6-21.5 9-33.2 8.7-18.4-2.5-36.2-8.1-52.6-16.6-34.9-13.9-72.8-18.3-108.8-29.1-11.1-3.3-21.9-7.3-33.1-10.3-5-1.2-9.9-2.7-14.7-4.7-4.7-2-8.8-5.4-11.5-9.7-2-3.5-3-7.5-2.9-11.5 0.1-4 0.9-7.9 2.3-11.5 2.7-7.5 7.1-14.2 10-21.6 4.4-12.2 6.1-25.3 5-38.2-0.6-12.9-2.9-25.8-3.6-38.7-0.6-5.8-0.4-11.6 0.6-17.3 1.5-11.4 10.4-20.5 21.9-22.2 5.3-0.9 10.6-1.3 15.9-1 5.3 0.3 10.7 0.3 16 0 5.3-0.3 10.6-1.8 15.3-4.3 4.3-2.6 8.1-6.2 11-10.4 2.9-4.2 5.5-8.5 7.9-13 2.4-4.5 5.1-8.7 8.3-12.7 3-4.1 7.1-7.2 11.8-9.4" fill="#F5BD0C" p-id="9291"></path><path d="M259.4 676.4c4.9-1.9 10.2-2.4 15.4-1.4 5.2 1 10.1 3.1 14.4 6.1 8.3 6.3 15.5 14.1 21.2 22.8 14.1 19.4 27.6 39.2 39.9 59.8 10 16.7 19.1 33.9 30.6 49.6 7.5 10.2 16 19.7 23.6 29.9 7.9 10 13.9 21.4 17.6 33.5 4.4 16.1 2.6 33.2-4.9 48.1-5.4 10.4-13.5 19.1-23.4 25.1-10 6-21.5 9-33.2 8.7-18.4-2.5-36.2-8.1-52.6-16.6-34.9-13.9-72.8-18.3-108.8-29.1-11.1-3.3-21.9-7.3-33.1-10.3-5-1.2-9.9-2.7-14.7-4.7-4.7-2-8.8-5.4-11.5-9.7-2-3.5-3-7.5-2.9-11.5 0.1-4 0.9-7.9 2.3-11.5 2.7-7.5 7.1-14.2 10-21.6 4.4-12.2 6.1-25.3 5-38.2-0.6-12.9-2.9-25.7-3.6-38.7-0.6-5.8-0.4-11.6 0.6-17.3 1.5-11.4 10.4-20.5 21.9-22.2 5.3-0.9 10.6-1.3 15.9-1 5.3 0.3 10.7 0.3 16 0 5.3-0.3 10.6-1.8 15.3-4.3 4.3-2.6 8.1-6.2 11-10.4 2.9-4.2 5.5-8.5 7.9-13 2.4-4.5 5.1-8.7 8.3-12.7 3-4.1 7.1-7.3 11.8-9.4" fill="#F5BD0C" p-id="9292"></path><path d="M267.1 684.8c4.4-1.7 9.3-2 13.9-0.9s8.9 3.2 12.6 6.2c7.1 6.2 13.1 13.6 17.6 21.9 12 19.4 23.7 39 34.6 59 7.9 15.3 16.8 30.1 26.6 44.2 6.8 9.2 14.6 17.6 21.6 26.6 7.3 8.9 12.8 19 16.2 29.9 4 14.3 2.3 29.6-4.5 42.9-5 9.4-12.5 17.3-21.7 22.6-9.2 5.4-19.8 8-30.4 7.5-16.7-2.6-32.9-7.6-48.2-14.9-30.4-11.1-63.5-12.5-94.7-21.2-11.2-3-22.1-7.1-33.4-9.9-5-1.1-10-2.5-14.8-4.3-4.8-1.8-9-5.2-11.8-9.5-1.8-3.4-2.7-7.2-2.5-11 0.2-3.8 1-7.6 2.4-11.2 2.7-7.1 7-13.6 9.7-20.7 3.8-11 5.1-22.6 3.9-34.2-0.8-11.5-2.9-22.9-3.5-34.5-0.4-5.1-0.2-10.3 0.7-15.4 0.9-5.1 3.3-9.8 6.9-13.6 4.2-3.8 9.4-6.3 15-7 5.6-0.7 11.2-0.7 16.7 0 5.6 0.7 11.2 0.9 16.8 0.8 11 0 21-6.4 25.7-16.4 2.3-4.5 4.3-9.2 5.9-13.9 1.7-4.8 4-9.3 6.7-13.6 2.8-4.3 6.8-7.7 11.5-9.7" fill="#F5BD0C" p-id="9293"></path></svg>
                    </div>
                    
                  </div>
                </div>
              </div>
                          </div>

          </div>
        </section>
      </div>
</template>
<script>
  export default {
    name: "tutorial",
     data() {
                    return {
                count: 0
            }
    },
    methods:{
             toWindow:function(id){
                this.$router.push({ path: 'window', query: { id: id}})
                console.log(id)
            },

           toAndroid:function(id){
                this.$router.push({ path: 'android', query: { id: id}})
                console.log(id)
            },

             toApple:function(id){
                this.$router.push({ path: 'apple', query: { id: id}})
                console.log(id)
            },

             toMac:function(id){
                this.$router.push({ path: 'mac', query: { id: id}})
                console.log(id)
            },
             toLinux:function(id){
                this.$router.push({ path: 'linux', query: { id: id}})
                console.log(id)
            }
        }
  }
</script>
<style scoped>
 /* @import "all.min.css"; */
 /* @import "bootstrap.min.css"; */
 /* @import "components.css"; */
 /* @import "malio.css"; */
 /* @import "style-purple.css"; */

 .row{
     display: flex;
     flex-direction: row ;
     justify-content: flex-start;
     flex-wrap: wrap;
     color: cornsilk;
     /* flex: 1; */
     margin: 20px;
     padding: 20px;
 }


   .col-lg-6{
    /* position: relative; */
    padding: 20px;
    margin: 20px;
    font-size: 18px;
    width: 400px;
    height: 180px;
    color: cornsilk;
    border: 1px solid #cccc;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
    /* display: flex;
    flex-direction: column; */
 
    }

   .windows-card{
      background-color:     #007bff;
    }
    .android-card{
      background-color:     #20c997;
    }

     .apple-card{
      background-color:    #343a40;
    }

     .mac-card{
      background-color:     #6c757d;
    }

     .linux-card{
      background-color:     #fd7e14;
    }
</style>