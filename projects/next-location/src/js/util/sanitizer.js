define(['lodash'], function (_) {

  function sanitizeText(text) {
    return simplifyPolishCharacters(_.deburr(_.escape(text)).toLowerCase());
  }

  function simplifyPolishCharacters(text) {
    return text
      .replace('ą', 'a')
      .replace('ć', 'c')
      .replace('ę', 'e')
      .replace('ł', 'l')
      .replace('ń', 'n')
      .replace('ó', 'o')
      .replace('ś', 's')
      .replace('ź', 'z')
      .replace('ż', 'z');
  }

  return {
    sanitizeText: sanitizeText
  };
});
