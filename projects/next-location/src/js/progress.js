define(function () {

  var maxProgressValue = 100;

  function setMaxValueTo(maxValue) {
    maxProgressValue = maxValue;
  }

  function updateTo(currentValue) {
    var asPercentage = (currentValue / maxProgressValue) * 100;
    $('#progress-bar').css('width', asPercentage + '%');
  }

  return {
    setMaxValueTo: setMaxValueTo,
    updateTo: updateTo
  };
});
