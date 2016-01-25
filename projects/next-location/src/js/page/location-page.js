define(['templates', 'progress', 'page/page-header', 'page/navigation', 'map/map-tab', 'task/task-tab', 'geocache/geocache-tab'],
  function (templates, progress, pageHeader, navigation, mapTab, taskTab, geocacheTab) {

    function loadInto(element, location) {
      $.when(
        templates.load('page/location-page.mst', location)
      ).then(function (html) {
          element.html(html);
          progress.updateTo(location.progress);
          pageHeader.loadInto($('#page-header'), location);
          navigation.loadInto($('#navigation'), location);
          if (!!location.staticText) {
            loadStaticContentFor(location);
          } else {
            loadTaskContentFor(location);
          }
        });
    }

    function loadStaticContentFor(location) {
      $.when(
        templates.load('page/static-content.mst', location)
      ).then(function (html) {
          $('#page-content').html(html);
        });
    }

    function loadTaskContentFor(location) {
      $.when(
        templates.load('page/task-content.mst', location)
      ).then(function (html) {
          $('#page-content').html(html);
          mapTab.loadInto($('#map-tab'), location);
          taskTab.loadInto($('#task-tab'), location);
          if (!!location.geocacheContentFile) {
            geocacheTab.loadInto($('#geocache-tab'), location);
          }
        });
    }

    return {
      loadInto: loadInto
    }
  });
