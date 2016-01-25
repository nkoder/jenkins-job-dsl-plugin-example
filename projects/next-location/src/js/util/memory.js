define(['util/logger', 'util/local-storage', 'util/transient-storage'],
  function (logger, localStorage, transientStorage) {

    var storage = chooseStorage();

    function chooseStorage() {
      if (!!localStorage.enabled) {
        logger.logDebug('Local storage is supported and will be used.');
        return localStorage;
      } else {
        logger.logDebug('Local storage is not supported. Transient storage will be used as fallback.');
        return transientStorage;
      }
    }

    function writeWithLogging(key, value) {
      write(key, value);
      logger.logDebug('stored ( ' + key + ' -> ' + read(key) + ' )');
    }

    function readWithLogging(key) {
      logger.logDebug('read ( ' + key + ' -> ' + read(key) + ' )');
      return read(key);
    }

    function write(key, value) {
      storage.set(key, value);
    }

    function read(key) {
      return storage.get(key);
    }

    return {
      write: writeWithLogging,
      read: readWithLogging
    };
  });
