AJS.$("#walkme-button").on("click", function() {
    var issueKey = AJS.context().issueKey;
    AJS.$.ajax({
        url: "/rest/api/2/issue/" + issueKey,
        type: "GET",
        success: function(data) {
            var description = data.fields.description;
            alert(description);
        }
    });
});
