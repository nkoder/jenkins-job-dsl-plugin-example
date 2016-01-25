define(['templates'],
  function (templates) {

    function loadInto(element, location) {
      $.when(
        templates.load('map/map.mst')
      ).then(function (html) {
          element.html(html);
          globalGoogleMapsHelper.loadGoogleMapsFor(
            location.googleMapsCoordinate.latitude,
            location.googleMapsCoordinate.longitude);
        });
    }

    return {
      loadInto: loadInto
    }
  });
