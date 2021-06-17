let body = document.getElementById("body");
let h1 = document.getElementById("title");
let mode_btn = document.getElementById("mode__button");
let isDark = false;
const changeBackgroundColor = () => {
  if (isDark) {
    body.style.background = "linear-gradient(to right, rgb(255, 255, 255), rgb(180, 255, 200))";
    h1.style.color = "black";
    h1.style.textShadow = "rgb(19, 18, 18) 2px 2px 5px";
    mode_btn.innerHTML = "To Dark Mode";
    isDark = false;
  } else {
    body.style.background = "linear-gradient(to right, rgb(0, 0, 0), rgb(20, 60, 30))";
    h1.style.color = "whitesmoke";
    h1.style.textShadow = "rgb(255, 253, 253) 2px 2px 5px";
    mode_btn.innerHTML = "To Light Mode";
    isDark = true;
  }
}

let introCode = document.getElementById("intro__code");
let isOpen = false;
const showIntroCode = () => {
  if (!isOpen) {
    introCode.style.display = "flex";
    isOpen = true;
  } else {
    introCode.style.display = "none";
    isOpen = false;
  }
}

let soccer = document.getElementById("soccer");
let photograph = document.getElementById("photograph");
let skiing = document.getElementById("skiing");
let traveling = document.getElementById("traveling");
let soccerIsOpen = false;
let photographIsOpen = false;
let skiingIsOpen = false;
let travelingIsOpen = false;
const showHobbiesMedia = (hobbie_id) => {
  switch (hobbie_id) {
    case "soccer_btn":
      if (!soccerIsOpen) {
        soccer.style.display = "flex";
        soccerIsOpen = true;
        photographIsOpen = false;
        photograph.style.display = "none";
        skiingIsOpen = false;
        skiing.style.display = "none";
        travelingIsOpen = false;
        traveling.style.display = "none";
      } else {
        soccer.style.display = "none";
        soccerIsOpen = false
      }
      break;
    case "photography_btn":
      if (!photographIsOpen) {
        photograph.style.display = "flex";
        photographIsOpen = true;
        soccerIsOpen = false;
        soccer.style.display = "none";
        skiingIsOpen = false;
        skiing.style.display = "none";
        travelingIsOpen = false;
        traveling.style.display = "none";
      } else {
        photograph.style.display = "none";
        photographIsOpen = false;
      }
      break;
    case "skiing_btn":
      if (!skiingIsOpen) {
        skiing.style.display = "flex";
        skiingIsOpen = true;
        soccerIsOpen = false;
        soccer.style.display = "none";
        photographIsOpen = false;
        photograph.style.display = "none";
        travelingIsOpen = false;
        traveling.style.display = "none";
      } else {
        skiing.style.display = "none";
        skiingIsOpen = false;
      }
      break;
    case "traveling_btn":
      if (!travelingIsOpen) {
        traveling.style.display = "flex";
        travelingIsOpen = true;
        photographIsOpen = false;
        photograph.style.display = "none";
        skiingIsOpen = false;
        skiing.style.display = "none";
        soccerIsOpen = false;
        soccer.style.display = "none";
      } else {
        traveling.style.display = "none";
        travelingIsOpen = false;
      }
      break;
    default:
      console.log("Wrong button");
  }
}