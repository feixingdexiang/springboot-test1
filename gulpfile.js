'use strict';

var gulp = require('gulp'),
    expect = require('gulp-expect-file'),
    es = require('event-stream'),
    sass = require('gulp-sass'),
    del = require('del'),
    rev = require('gulp-rev'),
    imagemin = require('gulp-imagemin'),
    browserSync = require('browser-sync'),
    changed = require('gulp-changed');


var config = require('./gulp/config');

gulp.task('clean',function(){
    return  del([config.dist],{dot:true});
});

gulp.task('sass', function () {
    return es.merge(
        gulp.src(config.sassSrc)
            .pipe(expect(config.sassSrc))
            .pipe(sass({includePaths:config.bower}).on('error', sass.logError))
            .pipe(gulp.dest(config.cssDir))
    );
});

gulp.task('styles', ['sass'], function () {
    return gulp.src(config.app + 'content/css')
        .pipe(browserSync.reload({stream: true}));
});

gulp.task('images',function(){
    return gulp.src(config.app + 'content/images/**')
        .pipe(changed(config.dist + 'content/images'))
        .pipe(imagemin({optimizationLevel: 5, progressive: true, interlaced: true}))
        .pipe(rev())
        .pipe(gulp.dest(config.dist + 'content/images'))
        .pipe(rev.manifest(config.revManifest, {
            base: config.dist,
            merge: true
        }))
        .pipe(gulp.dest(config.dist))
        .pipe(browserSync.reload({stream: true}));
})