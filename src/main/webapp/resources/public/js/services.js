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
});