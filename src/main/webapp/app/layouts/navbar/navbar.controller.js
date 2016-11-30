(function () {
    'use strict';

    angular
        .module('feytestApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$scope'];

    function NavbarController($scope) {
        $scope.isAuthenticated = true;
    }
})();
