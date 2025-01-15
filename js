<script type="module">
    AJS.toInit(function() {
        jQuery(document).ready(function() {
            initStuff();
        });
        initStuff();
    });

    if (typeof jQuery != "undefined") {
        jQuery(document).ready(function() {
            initStuff();
        });
    }

    document.addEventListener("DOMContentLoaded", function() {
        initStuff();
        JIRA.bind(JIRA.Events.NEW_CONTENT_ADDED, function() {
            initStuff();
        });
    });

    function initStuff() {
        if (AJS.$("#create-issue-dialog").is(":visible")) {
            alert("A new issue has been created!");
        }
    }
</script>





<web-resource key="my-jira-plugin-resources" name="My Jira Plugin Web Resources">
    <dependency>com.atlassian.auiplugin:ajs</dependency>
    <resource type="download" name="my-jira-plugin.js" location="/js/my-jira-plugin.js"/>
    <context>atl.general</context>
</web-resource>