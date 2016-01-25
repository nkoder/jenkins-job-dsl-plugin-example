define(function () {

  function load(templatePath, data) {
    var deferredTemplateLoad = $.Deferred();
    $.get('templates/' + templatePath)
      .done(function (template) {
        var renderedTemplate = Mustache.render(template, data);
        deferredTemplateLoad.resolve(renderedTemplate);
      }).fail(function () {
        deferredTemplateLoad.reject();
      });
    return deferredTemplateLoad;
  }

  return {
    load: load
  }
});
