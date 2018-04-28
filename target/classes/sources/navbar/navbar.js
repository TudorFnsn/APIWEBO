window.onscroll = function ()
{
    myFunction()
};

//var navbar = $("#navbar");
// var navbar = document.getElementById("navbar");
// console.log(document.getElementById("puta"));
// console.log(document.getElementById("navbar"));
// console.log("communication");
//var sticky = navbar.offsetTop;

var navbar;
var sticky;

function myFunction() {
    if (window.pageYOffset >= sticky)
    {
        navbar.classList.add("sticky")
    }
    else
        {
        navbar.classList.remove("sticky");
    }
}

$(document).ready(function () {


    navbar = document.getElementById("navbar");
    console.log(document.getElementById("puta"));
    console.log(document.getElementById("navbar"));
    console.log("communication");
    sticky = navbar.offsetTop;

    window.onscroll = function ()
     {
         myFunction();
     };

    //navbar.css()
});


