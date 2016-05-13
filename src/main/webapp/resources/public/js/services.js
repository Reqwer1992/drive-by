angular.module('ServicesModule', []).factory('SearchService', function() {
    var from, to;
    var setFrom = function(f){
        from = f;
    };
    var setTo = function(t){
        to = t;
    };
    var getTo = function(){
        return to;
    };
    var getFrom = function(){
        return from;
    };
    return {
        setFrom: setFrom,
        setTo: setTo,
        getFrom: getFrom,
        getTo: getTo
    };
})
.factory('DriveService', function () {
    var getDrives = function (from, to) {
        //var deferred = $q.defer();
        //$http.get("/drive/find?from=Rīga&to=Daugavpils").success(function(data, status) {
        //    if(status == 200){
        //        $scope.hello = data;
        //    }
        //});
        return {"aleksandr": "burda6ev"};
    };
    return {getDrives: getDrives}
});