define(['templates'],
  function (templates) {

    function loadInto(element, location) {
      $.when(
        templates.load('page/navigation.mst', location)
      ).then(function (html) {
          element.html(html);
          if (!!location.staticText) {
            enableNextPage();
          }
        });
    }

    function enableNextPage() {
      $('#go-next').attr('disabled', false);
    }

    function disableNextPage() {
      $('#go-next').attr('disabled', true);
    }

    return {
      loadInto: loadInto,
      enableNextPage: enableNextPage,
      disableNextPage: disableNextPage
    }
  });
