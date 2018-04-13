$('.navbar-sticky').affix({
    offset: {
        top: function () {
            return this.top = $('.navbar-sticky').offset().top
        }
    }
});
