define(['edison', 'page/location-page', 'locations', 'lodash'],
  function (Edison, locationPage, locations, _) {

    function configure() {

      var edison = new Edison({
        'container': 'dummy-route-container'
      });

      var section = createSection('locations');
      _.forEach(locations.all(), function (location) {
        section.createRoute({
          'name': location.id,
          'callback': function () {
            locationPage.loadInto($('#location-page'), location);
          }
        });
      });

      edison.initRoutes();

      function createSection(sectionPath) {
        return edison.createSection({
          'name': sectionPath,
          'callback': function () {
          }
        });
      }

    }

    function asFullUrlHash(pageId) {
      return '#!locations/' + pageId;
    }

    function isCurrentPageValid() {
      var correctPageIds = _.map(_.pluck(locations.all(), 'id'), asFullUrlHash);
      return _.contains(correctPageIds, window.location.hash);
    }

    function loadDefaultPage() {
      window.location.hash = asFullUrlHash(locations.defaultLocation().id);
    }

    return {
      configure: configure,
      isCurrentPageValid: isCurrentPageValid,
      loadDefaultPage: loadDefaultPage
    }
  });
