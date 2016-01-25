(function () {

  require.config({
    baseUrl: 'js/',
    paths: {
      'lodash': '../bower_components/lodash/lodash',
      'util/local-storage': '../bower_components/store.js/store'
    },
    'packages': [
      {
        'name': 'edison',
        'location': '../bower_components/edisonjs/dist',
        'main': 'edison'
      }
    ]
  });

  jQuery(document).ready(function () {
    require(['routing', 'progress', 'locations'], function (routing, progress, locations) {
      routing.configure();
      if (!routing.isCurrentPageValid()) {
        routing.loadDefaultPage();
      }
      progress.setMaxValueTo(locations.all().length - 1);
    });
  });

})();
