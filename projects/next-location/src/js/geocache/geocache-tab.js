define(['templates'],
  function (templates) {

    function loadInto(element, location) {
      $.when(
        templates.load(location.geocacheContentFile)
      ).then(function (html) {
          element.html(html)
        });
    }

    return {
      loadInto: loadInto
    }
  });
