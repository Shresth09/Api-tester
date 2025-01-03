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


<div>
    <button id="my-jira-button">Show Issue Description</button>

    <script>
        AJS.$("#my-jira-button").on("click", function() {
            var issueKey = AJS.context().issueKey;

            AJS.$.ajax({
                url: "/rest/api/3/issue/" + issueKey,
                type: "GET",
                headers: {
                    "Accept": "application/json"
                },
                success: function(data) {
                    var description = data.fields.description;
                    // Display the description in a modal, alert, or update the web panel content
                    alert(description); // Replace with your desired display method
                },
                error: function(xhr, status, error) {
                    console.error("Error fetching issue description:", error);
                    alert("Error fetching issue description. Please try again later.");
                }
            });
        });
    </script>
</div>




curl -u your_username:your_password -H "Accept: application/json" http://localhost:2990/jira/rest/api/3/issue/NEW-1


AJS.$("#my-jira-button").on("click", function() {
    var issueKey = AJS.context().issueKey;
    var token = "YOUR_API_TOKEN"; // Replace with your actual API token

    AJS.$.ajax({
        url: "/rest/api/3/issue/" + issueKey,
        type: "GET",
        headers: {
            "Accept": "application/json",
            "Authorization": "Bearer " + token
        },
        success: function(data) {
            var description = data.fields.description;
            // Display the description in a modal, alert, or update the web panel content
            alert(description); // Replace with your desired display method
        },
        error: function(xhr, status, error) {
            console.error("Error fetching issue description:", error);
            alert("Error fetching issue description. Please try again later.");
        }
    });
});





################
################

<div>
    <button id="walkme-button">WalkMe</button>
</div>

<script type="text/javascript">
    AJS.$(document).ready(function() {
        // Fetch the issue description
        var issueDescription = "$!issue.description";
        
        // Attach click event to the button
        AJS.$("#walkme-button").on("click", function() {
            alert(issueDescription);
        });
    });
</script> 