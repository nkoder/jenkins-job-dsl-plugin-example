define(['templates'],
  function (templates) {

    function loadInto(element, location) {
      $.when(
        templates.load('page/page-header.mst', location)
      ).then(function (html) {
          element.html(html);
        });
    }

    return {
      loadInto: loadInto
    }
  });
