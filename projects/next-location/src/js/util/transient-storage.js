define(function () {

  var data = {};

  function set(key, value) {
    data[key] = value;
  }

  function get(key) {
    return data[key];
  }

  function asText(value) {
    return value;
  }

  return {
    set: set,
    get: get
  };
});
