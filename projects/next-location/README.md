# next-location

Simple web page for city rally. Show coordinates of location and ask related question to unlock next location.

Main device for using this web page is Google Nexus 4 smartphone.

If you want to check how this website is working, you can go to [http://nkoder.github.io/next-location](http://nkoder.github.io/next-location) and use sample answers:

1. `#!locations/posag` --> `20`
2. `#!locations/grabki` --> `romb`
3. `#!locations/okna` --> `6`
4. `#!locations/lasery` --> `mapa`
4. `#!locations/reklama` --> `TOTO`
5. `#!locations/klatka` --> `scyzoryk `
6. `#!locations/brzozy` --> `Bronisław`
7. `#!locations/dobro` --> `Tacyt`

Important notes:

* the main language of the page is Polish
* `30 maja` is a date written in Polish; it is used on the page as a title of the event on which page is supposed to be used


## Setup project for development (on Ubuntu 14.10)

From the directory of the project:

1. `sudo apt-get install nodejs` to install `npm` globally

2. `sudo npm install -g bower` to install `bower` globally

3. `npm install --global gulp` to install `gulp` globally

4. `npm install` to install Node dependencies

5. `bower install` to install Bower dependencies

6. `gulp` to prepare project in `dist` folder and run server with it under [http://localhost:8000/index.html]()

## Deploy to Github Pages

From the directory of the project:

1. `gulp deploy:gh-pages`
     
2. Last command ends with strange error. A workaround is to force push.

        cd .publish
        git push --force origin gh-pages
        cd ..
        rm -rf .publish
