public class IssueCRUD extends HttpServlet (

private static final Logger Log LoggerFactory.getLogger(IssueCRUD.class);

I

private final TemplateRenderer templateRenderer;

private final PluginSettings Factory pluginSettingsFactory;

// setting the Storage key location

private static final String PLUGIN_STORAGE_KEY = "com.example.plugins.tutorial.servlet.IssueCRUD";

// setting the Default url for RQM

private static final String DEFAULT_API_URL = "default-url";

public IssueCRUD (TemplateRenderer templateRenderer, PluginSettings Factory pluginSettingsFactory) {

this.templateRenderer templateRenderer;

this.pluginSettingsFactory pluginSettingsFactory;
} 
@Override

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//Adding CORS for access from different origins

resp.setHeader("Access-Control-Allow-Origin", "*");

resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

// Check if the user is logged to the jira instance before accessing the URL

ApplicationUser user ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

GroupManager groupManager ComponentAccessor.getGroupManager();

if (user==null) {

resp.sendError(HttpServletResponse.SC_NOT_FOUND);

return;

}
// Check if the user is an admin

if (user == null || !groupManager.isUserInGroup(user, "jira-administrators")) {

}

resp.setStatus (HttpServletResponse.SC_FORBIDDEN);

resp.getWriter().write("You do not have permission to access this page.");

return;

String action req.getParameter("action");

// Fetch the current URL

if ("getUrl".equals(action)) {

}

PluginSettings pluginSettings pluginSettingsFactory.createGlobalSettings();

String apiurl = (String) pluginSettings.get(PLUGIN_STORAGE_KEY + ".apiUrl");

if (apiurl == null) {

}

apiurl= DEFAULT_API_URL;

resp.setContentType("application/json");

resp.getWriter().write("{\"apiurl\":\"" + apiurl + "\"}");

// Update the URL

else if ("updateUrl".equals(action)) {

try {

String newUrl = req.getParameter("url");

PluginSettings pluginSettings pluginSettingsFactory.createGlobalSettings();

pluginSettings.put(PLUGIN_STORAGE_KEY + ".apiUrl", newUrl);

resp.setContentType("text/plain");

resp.getWriter().write("URL updated successfully!");

} catch (Exception e) {

Log.error("Error processing update URL request", e);

resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

resp.getWriter().write("Error processing request!");

1

}else if ("getProjects".equals(action)) {

Project Manager projectManager ComponentAccessor.getProjectManager(); List<Project> projects projectManager.getProjectObjects();

// sending only the project key and project name for display String projectList = projects.stream() map(project project.getKey() + "-" + project.getName())

.collect(Collectors.joining(","));

resp.setContentType("text/plain"); resp.getWriter().write(projectList);

// Fetch the selected projects

}else if ("getSelected Projects".equals(action)) {

PluginSettings pluginSettings pluginSettingsFactory.createGlobalSettings(); String selectedProjects = (String) pluginSettings.get(PLUGIN_STORAGE_KEY + ".selectedProjects");

if (selectedProjects == null) {

selected Projects = "";

}

resp.setContentType("text/plain");

resp.getWriter().write(selectedProjects);

// Apply the selected projects

} else if ("applySelection".equals(action)) {
            String projectKeys = req.getParameter("keys");
            if ("SELECT-ALL-CHECKED".equals(projectKeys)) {
                ProjectManager projectManager = ComponentAccessor.getProjectManager();
                List<Project> projects = projectManager.getProjectObjects();
                projectKeys = projects.stream().map(Project::getKey).collect(Collectors.joining(","));
            }
            PluginSettings pluginSettings = pluginSettingsFactory.createGlobalSettings();
            pluginSettings.put(PLUGIN_STORAGE_KEY + ".selectedProjects", projectKeys);
            resp.setContentType("text/plain");
            resp.getWriter().write("Projects applied successfully!");
        } 
else {

resp.setContentType("text/html; charset=utf-8");

templateRenderer.render("templates/issuecrud-page.vm", resp.getWriter());

}

}
} 