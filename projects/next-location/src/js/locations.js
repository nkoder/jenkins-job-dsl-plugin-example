define(['lodash'], function (_) {

  function all() {
    return [
      {
        isDefault: true,
        id: 'start',
        nextId: 'posag',
        title: '30 maja',
        progress: 0,
        wgs84Coordinate: {
          latitude: 'N52°14\'06.7"',
          longitude: 'E21°00\'30.6"'
        },
        staticText: 'Witaj! Czas zacząć Twój niepowtarzalny Wieczór Kawalerski! Kliknij \'Dalej\' i lecimy!'
      },
      {
        previousId: 'start',
        id: 'posag',
        nextId: 'grabki',
        title: 'Posag',
        progress: 1,
        wgs84Coordinate: {
          latitude: 'N52°12\'10.1"',
          longitude: 'E20°52\'34.3"'
        },
        googleMapsCoordinate: {
          latitude: '52.2028',
          longitude: '20.8762'

        },
        task: {
          question: 'Ile ząbków ma na głowie monstrum?',
          correctAnswers: ['20', 'dwadzieścia', 'dwie dziesiątki']
        }
      },
      {
        previousId: 'posag',
        id: 'grabki',
        nextId: 'okna',
        title: 'Grabki',
        progress: 2,
        wgs84Coordinate: {
          latitude: 'N52°12\'05.328"',
          longitude: 'E20°51\'53.388"'
        },
        googleMapsCoordinate: {
          latitude: '52.20148',
          longitude: '20.86483'

        },
        task: {
          question: 'Jak nazywa się fajna figura, która dwa razy pojawia się na ciekawej metalowej furtce?',
          correctAnswers: ['romb', 'rąb', 'rołb']
        },
        geocacheContentFile: 'geocache/geocache-grabki-content.mst'
      },
      {
        previousId: 'grabki',
        id: 'okna',
        nextId: 'lasery',
        title: 'Okna',
        progress: 3,
        wgs84Coordinate: {
          latitude: 'N52°12\'17.6"',
          longitude: 'E20°52\'21"'
        },
        googleMapsCoordinate: {
          latitude: '52.2049',
          longitude: '20.8725'

        },
        task: {
          question: 'Ile okien ma tunel nad jezdnią od widocznej tutaj strony?',
          correctAnswers: ['6', 'sześć']
        }
      },
      {
        previousId: 'okna',
        id: 'lasery',
        nextId: 'reklama',
        title: 'Lasery',
        progress: 4,
        wgs84Coordinate: {
          latitude: 'N52°12\'19"',
          longitude: 'E20°52\'26"'
        },
        googleMapsCoordinate: {
          latitude: '52.205278',
          longitude: '20.873889'

        },
        task: {
          question: 'Miłej zabawy! Po zakończeniu wpisz nazwę artefaktu, który zdobyłeś.',
          correctAnswers: ['mapa', 'kartka', 'plan']
        }
      },
      {
        previousId: 'lasery',
        id: 'reklama',
        nextId: 'klatka',
        title: 'Reklama',
        progress: 5,
        wgs84Coordinate: {
          latitude: 'N52°13\'52.5"',
          longitude: 'E21°00\'51.1"'
        },
        googleMapsCoordinate: {
          latitude: '52.23125',
          longitude: '21.0142'

        },
        task: {
          question: 'W jaki napis układają się białe figury na brzydkim budynku?',
          correctAnswers: ['TOTO', 'TO TO', 'T.O.T.O.', 'T O T O']
        }
      },
      {
        previousId: 'reklama',
        id: 'klatka',
        nextId: 'brzozy',
        title: 'Klatka',
        progress: 6,
        wgs84Coordinate: {
          latitude: 'N52°13\'52"',
          longitude: 'E21°00\'49"'
        },
        googleMapsCoordinate: {
          latitude: '52.231111',
          longitude: '21.013611'

        },
        task: {
          question: 'Kieruj się pod adres Widok 18 lok. 6. Po wyjściu stamtąd odpowiedz, jaki przedmiot otrzymałeś.',
          correctAnswers: ['scyzoryk', 'multitool']
        }
      },
      {
        previousId: 'klatka',
        id: 'brzozy',
        nextId: 'dobro',
        title: 'Brzozy',
        progress: 7,
        wgs84Coordinate: {
          latitude: 'N52°13\'55.9"',
          longitude: 'E21°01\'01.4"'
        },
        googleMapsCoordinate: {
          latitude: '52.232194',
          longitude: '21.017056'

        },
        task: {
          question: 'Jak na imię miał architekt, który zaprojektował Pałac Brzozowskich? Nie, nie zaglądamy do Wikipedii…',
          correctAnswers: ['Bronisław', 'Bronek']
        },
        geocacheContentFile: 'geocache/geocache-brzozy-content.mst'
      },
      {
        previousId: 'brzozy',
        id: 'dobro',
        nextId: 'chaos',
        title: 'Dobro',
        progress: 8,
        wgs84Coordinate: {
          latitude: 'N52°13\'50.4"',
          longitude: 'E21°01\'14.1"'
        },
        googleMapsCoordinate: {
          latitude: '52.230667',
          longitude: '21.020583'
        },
        task: {
          question: 'Jak się nazywał rzymski historyk, którego myśl zainspirowała pomysłodawców pomnika.',
          correctAnswers: ['Tacyt', 'Publiusz', 'Publiusz Korneliusz', 'Publiusz Korneliusz Tacyt', 'Publiusz Tacyt', 'Tacitus', 'Cornelius', 'Cornelius Tacitus']
        },
        geocacheContentFile: 'geocache/geocache-dobro-content.mst'
      },
      {
        previousId: 'dobro',
        id: 'chaos',
        title: 'Chaos',
        progress: 9,
        wgs84Coordinate: {
          latitude: 'brak danych',
          longitude: 'brak danych'
        },
        staticText: 'Jesteś już prawie u celu. Zastanawiasz się może, jakie jest przeznaczenie mapy, którą dostałeś? Twoi dzielni kamraci mogą Ci pomóc!'
      }
    ];
  }

  function defaultLocation() {
    return _.find(all(), function (location) {
      return !!location.isDefault;
    });
  }

  return {
    all: all,
    defaultLocation: defaultLocation
  }
});
