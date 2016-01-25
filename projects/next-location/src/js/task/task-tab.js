define(['templates', 'util/memory', 'util/sanitizer', 'page/navigation'],
  function (templates, memory, sanitizer, navigation) {

    function loadInto(element, location) {
      $.when(
        templates.load('task/task-form.mst', location)
      ).then(function (html) {
          element.html(html);
          userAnswerElement().bind('input', onUserAnswerChangedAction);
          userAnswerElement().val(memory.read(location.id));
          onUserAnswerChangedAction();
        });

      function onUserAnswerChangedAction() {
        memory.write(location.id, userAnswerElement().val());
        var userAnswer = sanitizer.sanitizeText(userAnswerElement().val());
        var correctAnswers = _.map(location.task.correctAnswers, sanitizer.sanitizeText);
        var hasUserFoundTheAnswer = _.reduce(correctAnswers, function (foundTheAnswer, correctAnswer) {
          return foundTheAnswer || (correctAnswer === userAnswer);
        }, false);
        updatePageAccordingToAnswerCorrectness(hasUserFoundTheAnswer);
      }
    }

    function userAnswerElement() {
      return $('#user-answer');
    }

    function updatePageAccordingToAnswerCorrectness(hasUserFoundTheAnswer) {
      if (hasUserFoundTheAnswer) {
        navigation.enableNextPage();
      } else {
        navigation.disableNextPage();
      }
      $('#user-answer')
        .closest('.form-group')
        .toggleClass('has-success', hasUserFoundTheAnswer);
    }

    return {
      loadInto: loadInto
    }
  });
