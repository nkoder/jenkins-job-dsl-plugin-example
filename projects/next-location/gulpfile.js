var gulp = require('gulp');

var del = require('del');
var ghPages = require('gulp-gh-pages');
var liveServer = require("live-server");

var paths = {
  cname: 'src/CNAME',
  index: 'src/index.html',
  robots: 'src/robots.txt',
  js: 'src/js/**/*.js',
  css: 'src/css/**/*.css',
  templates: 'src/templates/**/*.mst',
  bower: [
    'src/bower_components/bootstrap/dist/css/bootstrap.css',
    'src/bower_components/bootstrap/dist/css/bootstrap.css.map',
    'src/bower_components/bootstrap/dist/js/bootstrap.js',
    'src/bower_components/bootstrap/dist/fonts/*',
    'src/bower_components/requirejs/require.js',
    'src/bower_components/lodash/lodash.js',
    'src/bower_components/font-awesome/css/font-awesome.css',
    'src/bower_components/font-awesome/fonts/*',
    'src/bower_components/mustache/mustache.js',
    'src/bower_components/jquery/dist/jquery.js',
    'src/bower_components/store.js/store.js',
    'src/bower_components/font-awesome/css/font-awesome.css',
    'src/bower_components/edisonjs/dist/edison.js'
  ]
};

gulp.task('clean:cname', function (cb) {
  del('dist/CNAME', cb);
});

gulp.task('clean:index', function (cb) {
  del('dist/index.html', cb);
});

gulp.task('clean:robots', function (cb) {
  del('dist/robots.txt', cb);
});

gulp.task('clean:js', function (cb) {
  del('dist/js/', cb);
});

gulp.task('clean:css', function (cb) {
  del('dist/css/', cb);
});

gulp.task('clean:templates', function (cb) {
  del('dist/templates/', cb);
});

gulp.task('clean:bower', function (cb) {
  del('dist/bower_components/', cb);
});

gulp.task('dist:cname', ['clean:cname'], function () {
  return gulp.src(paths.cname)
    .pipe(gulp.dest('dist/'));
});

gulp.task('dist:index', ['clean:index'], function () {
  return gulp.src(paths.index)
    .pipe(gulp.dest('dist/'));
});

gulp.task('dist:robots', ['clean:robots'], function () {
  return gulp.src(paths.robots)
    .pipe(gulp.dest('dist/'));
});

gulp.task('dist:js', ['clean:js'], function () {
  return gulp.src(paths.js)
    .pipe(gulp.dest('dist/js/'));
});

gulp.task('dist:css', ['clean:css'], function () {
  return gulp.src(paths.css)
    .pipe(gulp.dest('dist/css/'));
});

gulp.task('dist:templates', ['clean:templates'], function () {
  return gulp.src(paths.templates)
    .pipe(gulp.dest('dist/templates/'));
});

gulp.task('dist:bower', ['clean:bower'], function () {
  return gulp.src(paths.bower, {base: 'src/bower_components/'})
    .pipe(gulp.dest('dist/bower_components/'));
});

gulp.task('dist', ['dist:cname', 'dist:index', 'dist:robots', 'dist:js', 'dist:css', 'dist:templates', 'dist:bower']);


gulp.task('watch', function () {
  gulp.watch(paths.cname, ['dist:cname']);
  gulp.watch(paths.index, ['dist:index']);
  gulp.watch(paths.robots, ['dist:robots']);
  gulp.watch(paths.js, ['dist:js']);
  gulp.watch(paths.css, ['dist:css']);
  gulp.watch(paths.templates, ['dist:templates']);
  gulp.watch(paths.bower, ['dist:bower']);
});

gulp.task('distThenWatch', ['dist'], function () {
  gulp.run('watch');
});

gulp.task('serve', function () {
  liveServer.start({
    port: 8080,
    host: "localhost",
    root: "src/",
    open: true
  });
});

gulp.task('serve:dist', function () {
  liveServer.start({
    port: 8080,
    host: "localhost",
    root: "dist/",
    open: true
  });
});

gulp.task('deploy:gh-pages', ['dist'], function () {
  return gulp.src('./dist/**/*')
    .pipe(ghPages({
      remoteUrl: 'git@github.com:nkoder/next-location.git',
      branch: 'gh-pages',
      cacheDir: '.publish'
    }));
});

gulp.task('default', ['distThenWatch'], function () {
  gulp.run('serve:dist');
});
