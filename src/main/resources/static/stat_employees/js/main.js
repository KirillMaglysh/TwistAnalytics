(function ($) {

    "use strict";


})(jQuery);

function sortByHeader(param, curHeader, isAsc) {
    let isAscNow = (param === curHeader && isAsc === "true") ? "false" : "true";
    window.location.href = `/employees?limit=8&offset=0&sortParam=${param}&isAsc=${isAscNow}`
}

function loadNextPage(param, isAsc, limit, offset) {
    window.location.href = `/employees?limit=${limit}&offset=${parseInt(offset) + 1}&sortParam=${param}&isAsc=${isAsc}`
}

function loadPrevPage(param, isAsc, limit, offset) {
    if (parseInt(offset) === 0) {
        return
    }

    window.location.href = `/employees?limit=${limit}&offset=${parseInt(offset) - 1}&sortParam=${param}&isAsc=${isAsc}`;
}

function loadProfile(id) {
    window.location.href = `/profile/${id}`
}