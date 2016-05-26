angular.module('SearchApp', ['ServicesModule', 'ngCookies', 'spring-security-csrf-token-interceptor'])
    .controller('SearchCtrl', ['$scope', 'SearchService', '$cookieStore',
        function($scope, SearchService, $cookieStore) {

            $scope.fromLocalities = [];
            $scope.toLocalities = [];

            $scope.onSearch = function(){
                $cookieStore.put('from', $scope.from);
                $cookieStore.put('to', $scope.to);
                window.location.replace('/resources/public/search-results.html');
            };

            $scope.$watch('from', function (tmpStr){
                if (!tmpStr || tmpStr.length == 0) return 0;
                if (tmpStr === $scope.from){
                    $scope.fromLocalities = [];
                    SearchService.autocomplete(tmpStr).then(function(data){
                        if(data.localities.indexOf(tmpStr) < 0){
                            $scope.fromLocalities = data.localities;
                        }
                    });
                }
            });

            $scope.$watch('to', function (tmpStr){
                if (!tmpStr || tmpStr.length == 0) return 0;
                if (tmpStr === $scope.to){
                    $scope.toLocalities = [];
                    SearchService.autocomplete(tmpStr).then(function(data){
                        console.log(data);
                        if(data.localities.indexOf(tmpStr) < 0){
                            $scope.toLocalities = data.localities;
                        }
                    });
                }
            });
        }
    ]);