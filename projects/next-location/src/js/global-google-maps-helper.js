(function () {

  globalGoogleMapsHelper = {
    reloadGoogleMaps: reloadGoogleMaps,
    loadGoogleMapsFor: loadGoogleMapsFor
  };

  var latitude = undefined;
  var longitude = undefined;
  var isMapLoaded = false;

  function loadGoogleMapsFor(newLatitude, newLongitude) {
    latitude = newLatitude;
    longitude = newLongitude;
    if (!isMapLoaded) {
      isMapLoaded = true;
      var script = document.createElement('script');
      script.type = 'text/javascript';
      script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp' +
        '&signed_in=false&callback=globalGoogleMapsHelper.reloadGoogleMaps';
      document.body.appendChild(script);
    } else {
      reloadGoogleMaps();
    }
  }

  function reloadGoogleMaps() {
    var position = new google.maps.LatLng(latitude, longitude);
    var options = {
      zoom: 16,
      disableDefaultUI: true,
      center: position,
      panControl: true,
      zoomControl: true,
      scaleControl: true
    };
    var map = new google.maps.Map(document.getElementById('map-canvas'), options);
    var marker = new google.maps.Marker({
      position: position,
      url: 'https://maps.google.com/?q=' + latitude + '+' + longitude,
      map: map
    });
    google.maps.event.addListener(marker, 'click', function () {
      window.open(marker.url);
    });
  }

})();
