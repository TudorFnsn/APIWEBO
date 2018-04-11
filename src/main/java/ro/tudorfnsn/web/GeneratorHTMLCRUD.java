package ro.tudorfnsn.web;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.UnaryOperator;

public class GeneratorHTMLCRUD
{
    protected Class theClass;

    protected static String lineSeparator = System.getProperty("line.separator");

    protected String pageTitle;
    protected String subTitle;
    protected String fileName;
    protected String tableName;
    protected String apiUrl;
    protected String elementsPath;

    protected List<String> fields;

    protected List<String> libraries;

    protected List<String> styles;

    protected List<String> scriptVariables;

    protected List<String> scriptFunctions;

    protected List<String> readyElements;

    protected List<String> scripts;

    protected List<String> headers;

    protected List<String> bodyElements;

    protected List<String> htmlElements;

    protected Map<String, UnaryOperator<String>> conditionFieldGetAll;

    protected Map<String, UnaryOperator<String>> conditionFieldModalUpdate;

    protected Map<String, UnaryOperator<String>> conditionModalCreateCreate;

    protected Map<String, UnaryOperator<String>> conditionModalUpdateCreate;

    protected Map<String, UnaryOperator<String>> conditionFieldCreateButton;

    protected Map<String, UnaryOperator<String>> conditionFieldUpdateButton;


    public GeneratorHTMLCRUD(Class theClass, String apiUrl, String path)
    {
        this.theClass = theClass;
        this.fields = getFieldNames(theClass);

        this.pageTitle = path;
        this.subTitle = "administration";
        this.fileName = path;

        this.tableName = theClass.getSimpleName();

        this.apiUrl = apiUrl;
        this.elementsPath = path;

        libraries = new ArrayList<>();
        styles = new ArrayList<>();
        scriptVariables = new ArrayList<>();
        scriptFunctions = new ArrayList<>();
        readyElements = new ArrayList();
        bodyElements = new ArrayList<>();

        conditionFieldGetAll = new HashMap<>();

        conditionFieldModalUpdate = new HashMap<>();

        conditionModalCreateCreate = new HashMap<>();

        conditionModalUpdateCreate = new HashMap<>();

        conditionFieldCreateButton = new HashMap<>();

        conditionFieldUpdateButton = new HashMap<>();

    }



    public void create()
    {
        setLibraries();
        setStyles();
        setScriptVariables();
        setScriptFunctions();
        setScripts();
        setHeader();
        setBody();
        setHtml();


        writeElementToFile(fileName, getHtml());
    }

    public void addLibrary(String library)
    {
        libraries.add(library);
    }


    private void setLibraries()
    {

        addLibrary("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></link>");
        addLibrary("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        addLibrary("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
        addLibrary("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></link>");

    }

    public void addStyle(String element, String style)
    {
        styles.add(element + "{ " + style + "}");
    }

    private void setStyles()
    {

        addStyle("body", "background: fixed; " +
                "background-image: url(\"https://wallpaperscraft.com/image/city_street_house_sidewalk_58870_1920x1200.jpg\"); " +
                "background-size: cover; " +
                "background-repeat: no-repeat; " +
                "background-position: center; ");

        addStyle("table", "background-color: rgba(0, 0, 0, 0.7);" +
                "color: aliceblue; " );

        addStyle("#tableContainer", "padding-left: 5vw;" +
                "padding-right: 5vw ");

        addStyle(".table-hover tbody tr:hover td",
                "  background-color: rgba(0, 0, 0, 0.9); ");

        addStyle(".modal-content",
                "        background-color: rgba(0, 0, 0, 0.7);color: aliceblue; " +
                        "        border-color: aliceblue; " +
                        "        border-width: 1px; ");


        addStyle(".modal",
                "        top: 50%; " +
                        "        left: 50%; " +
                        "        transform: translate(-50%, -50%); ");


        addStyle(".table-hover tbody tr", "height:10vh; ");


        addStyle(".close",
                "            color: aliceblue; " +
                        "            opacity:1;");

        addStyle(".jumbotron",
                "        color: aliceblue; " +
                        "        background-color: black; " +
                        "        padding-left: 5vw; ");

        addStyle(".btn","width: 90%; ");

    }

    public void addScriptVariable(String name)
    {
        scriptVariables.add("var " + name + ";");
    }

    public void addScriptVariable(String name, String content)
    {
        scriptVariables.add("var " + name + "=" + content);
    }

    private void setScriptVariables()
    {

        addScriptVariable("apiUrl","'" + apiUrl + "';");
        addScriptVariable("elementsPath", "'" + elementsPath + "';");
    }

    public void addGetAllFieldCondition(String field, UnaryOperator<String> condition)
    {
        conditionFieldGetAll.put(field, condition);
    }

    private String functionGetAllElements()
    {
        StringBuilder jsGetAllElements = new StringBuilder();

        jsGetAllElements.append("function getElementsList()");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("{");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("$('#table" + theClass.getSimpleName() + " tbody').empty();");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("$.getJSON(apiUrl + elementsPath + '/', null, function(data)");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("{");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("$.each(data, function(index, item)");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("{");
        jsGetAllElements.append(lineSeparator);

        jsGetAllElements.append("var row='<tr>';");
        jsGetAllElements.append(lineSeparator);

        for(String field : fields)
        {

            if(conditionFieldGetAll.containsKey(field))
            {
                jsGetAllElements.append(conditionFieldGetAll.get(field).apply(field));
                jsGetAllElements.append(lineSeparator);
            }
            else
            {
                jsGetAllElements.append("row = row + '<td class=\"data" + field + "\" >' + item." + field + " + '</td>';");
                jsGetAllElements.append(lineSeparator);
            }


        }
        // the edit button
        jsGetAllElements.append("row = row + '<td><button class=\"btn btn-primary edit-item editMenu_item\">Edit</button></td>';");
        // the delete button
        jsGetAllElements.append("row = row + '<td><button class=\"btn btn-danger remove-item deleteMenu_item\">Delete</button></td>';");
        jsGetAllElements.append(lineSeparator);

        jsGetAllElements.append("row= row + '</tr>';");

        jsGetAllElements.append(lineSeparator);
        // we append the row
        jsGetAllElements.append("$('#table" + theClass.getSimpleName() + " tbody:last-child').append(row);");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("});");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("});");
        jsGetAllElements.append(lineSeparator);
        jsGetAllElements.append("}");
        jsGetAllElements.append(lineSeparator);

        return jsGetAllElements.toString();
    }

    public void addEditModalCondition(String field, UnaryOperator<String> condition)
    {
        conditionFieldModalUpdate.put(field, condition);
    }

    private String onEditModalButton()
    {
        StringBuilder htmlShowEditModal = new StringBuilder();

        htmlShowEditModal.append("$(document).on('click','.editMenu_item', function(){");
        htmlShowEditModal.append(lineSeparator);
        for(String field : fields)
        {
            if(conditionFieldModalUpdate.containsKey(field))
            {
                htmlShowEditModal.append(conditionFieldModalUpdate.get(field).apply(field));
                htmlShowEditModal.append(lineSeparator);
            }
            else
            {
                htmlShowEditModal.append("var " + field + "data = ($(this).parent().parent()).find('.data" + field + "').html();");
                htmlShowEditModal.append(lineSeparator);
                htmlShowEditModal.append("$('#edit" + field + "').val(" + field + "data);");
                htmlShowEditModal.append(lineSeparator);
            }


        }
        htmlShowEditModal.append("$('#edit-item').modal('show');");
        htmlShowEditModal.append(lineSeparator);
        htmlShowEditModal.append("});");
        htmlShowEditModal.append(lineSeparator);

        return htmlShowEditModal.toString();
    }


    private String onDeleteClick()
    {
        StringBuilder htmlOnDeleteClick = new StringBuilder();

        htmlOnDeleteClick.append("$(document).on('click','.deleteMenu_item', function() {");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("var iddata = ($(this).parent().parent()).find('.dataid').html();");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("$.ajax({");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("url: apiUrl + elementsPath + '/' + iddata,");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("type: 'DELETE',");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("success: function(result) {");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("getElementsList();");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("alert(result);");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("},");
        htmlOnDeleteClick.append("error: function(xhr, textStatus, errorThrown){\n" +
                "       alert(xhr.responseText);\n" +
                "    }");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append("});");
        htmlOnDeleteClick.append(lineSeparator);
        htmlOnDeleteClick.append(" });");
        htmlOnDeleteClick.append(lineSeparator);

        return htmlOnDeleteClick.toString();
    }

    public void addCreateButtonFieldCondition(String field, UnaryOperator<String> condition)
    {
        conditionFieldCreateButton.put(field, condition);
    }

    private String onAddClick()
    {
        StringBuilder htmlOnAddClick = new StringBuilder();

        htmlOnAddClick.append("$(document).on('click', '#add_button', function () {");
        htmlOnAddClick.append(lineSeparator);

        for(String field : fields)
        {
            if(conditionFieldCreateButton.containsKey(field))
            {
                htmlOnAddClick.append(conditionFieldCreateButton.get(field).apply(field));
                htmlOnAddClick.append(lineSeparator);
            }
            else
            {
                htmlOnAddClick.append("var " + field + "data = $('#create" + field + "').val();");
                htmlOnAddClick.append(lineSeparator);
            }
        }

        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("var jsonCreate = '{");

        for(String field : fields)
        {
            htmlOnAddClick.append("\"" + field + "\":\"' + " + field + "data +'\",");
        }

        htmlOnAddClick.deleteCharAt(htmlOnAddClick.length() - 1);

        htmlOnAddClick.append("}';");

        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("$.ajax({");
        htmlOnAddClick.append("headers: { \n" +
                "        'Accept': 'application/json',\n" +
                "        'Content-Type': 'application/json' \n" +
                "    },");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("url: apiUrl + elementsPath + '/',");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("type: 'POST',");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("data: jsonCreate,");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("dataType: 'text',");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("success: function(result) {");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("getElementsList();");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("alert(result);");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("}");

        htmlOnAddClick.append("});");
        htmlOnAddClick.append(lineSeparator);
        htmlOnAddClick.append("});");

        return htmlOnAddClick.toString();
    }

    public void addUpdateButtonFieldCondition(String field, UnaryOperator<String> condition)
    {
        conditionFieldUpdateButton.put(field, condition);
    }


    private String onUpdateClick()
    {
        StringBuilder htmlOnUpdateClick = new StringBuilder();


        htmlOnUpdateClick.append("$(document).on('click', '#update_button', function () {");
        htmlOnUpdateClick.append(lineSeparator);

        for(String field : fields)
        {
            if(conditionFieldUpdateButton.containsKey(field))
            {
                htmlOnUpdateClick.append(conditionFieldUpdateButton.get(field).apply(field));
                htmlOnUpdateClick.append(lineSeparator);
            }
            else
            {
                htmlOnUpdateClick.append("var " + field + "data = $('#edit" + field + "').val();");
                htmlOnUpdateClick.append(lineSeparator);
            }

        }

        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("var jsonEdit = '{");

        for(String field : fields)
        {
            htmlOnUpdateClick.append("\"" + field + "\":\"' + " + field + "data +'\",");
        }

        htmlOnUpdateClick.deleteCharAt(htmlOnUpdateClick.length() - 1);

        htmlOnUpdateClick.append("}';");

        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("$.ajax({");
        htmlOnUpdateClick.append("headers: { \n" +
                "        'Accept': 'application/json',\n" +
                "        'Content-Type': 'application/json' \n" +
                "    },");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("url: apiUrl + elementsPath + '/' + iddata,");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("type: 'POST',");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("data: jsonEdit,");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("dataType: 'text',");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("success: function(result) {");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("getElementsList();");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("alert(result);");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("}");

        htmlOnUpdateClick.append("});");
        htmlOnUpdateClick.append(lineSeparator);
        htmlOnUpdateClick.append("});");

        return htmlOnUpdateClick.toString();

    }

    private String onRefreshClick()
    {
        return "$(document).on('click', '#refresh_menu_button', function () {" +
                "getElementsList();});";
    }


    public void addToFunctionReady(String element)
    {
        readyElements.add(element);
    }

    private String functionReady()
    {

        addToFunctionReady("getElementsList();");
        addToFunctionReady(onEditModalButton());
        addToFunctionReady(onDeleteClick());
        addToFunctionReady(onAddClick());
        addToFunctionReady(onUpdateClick());
        addToFunctionReady(onRefreshClick());

        StringBuilder htmlFunctionReady = new StringBuilder();
        htmlFunctionReady.append(lineSeparator);

        htmlFunctionReady.append("$(document).ready(");
        htmlFunctionReady.append(lineSeparator);
        htmlFunctionReady.append("function()");
        htmlFunctionReady.append("{");

        for(String readyElement : readyElements)
        {
            htmlFunctionReady.append(readyElement);
            htmlFunctionReady.append(lineSeparator);
        }

        htmlFunctionReady.append("});");
        htmlFunctionReady.append(lineSeparator);

        return htmlFunctionReady.toString();


    }

    public void addScriptFunction(String function)
    {
        scriptFunctions.add(function);
    }

    private void setScriptFunctions()
    {

        addScriptFunction(functionGetAllElements());
        addScriptFunction(functionReady());

    }


    private void setScripts()
    {
        scripts = new ArrayList<>();

        scripts.add(getScriptVariables());
        scripts.add(getScriptFunctions());


    }

    private void setHeader()
    {
        headers = new ArrayList<>();

        headers.add("<meta charset='utf-8' />");
        headers.add("<meta name='viewport' content='width=device-width, initial-scale=1' />");
        headers.add("<title>" + pageTitle + "</title>");
        headers.add(getLibraries());
        headers.add(getStyle());
        headers.add(getScript());
    }

    private String createJumbotron()
    {
        StringBuilder htmlJumbotron = new StringBuilder();

        htmlJumbotron.append("<div class='jumbotron'>");
        htmlJumbotron.append(lineSeparator);
        htmlJumbotron.append("<h1>" + tableName + "<small> " + subTitle + "</small></h1>");
        htmlJumbotron.append(lineSeparator);
        htmlJumbotron.append("</div>");

        return htmlJumbotron.toString();
    }

    public void addConditionModalCreateCreate(String field, UnaryOperator<String> condition)
    {
        conditionModalCreateCreate.put(field, condition);
    }

    private String createCreateModal()
    {
        StringBuffer createModal = new StringBuffer();

        createModal.append("<div class='modal fade' id='create-item' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>");
        createModal.append(lineSeparator);
        createModal.append("<div class='modal-content'>");
        createModal.append(lineSeparator);
        createModal.append("<div class='modal-header'>");
        createModal.append(lineSeparator);
        createModal.append("<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>◊</span></button>");
        createModal.append(lineSeparator);
        createModal.append("<h4 class='modal-title' id='myModalLabel'>Create Item</h4>");
        createModal.append(lineSeparator);
        createModal.append("</div>");
        createModal.append(lineSeparator);
        createModal.append("<div class='modal-body'>");
        createModal.append(lineSeparator);
        createModal.append("<form id='add_input'>");
        createModal.append(lineSeparator);
        createModal.append("<table class='table table-hover'>");
        createModal.append(lineSeparator);
        for (String field : fields)
        {
            if(conditionModalCreateCreate.containsKey(field))
            {
                createModal.append(conditionModalCreateCreate.get(field).apply(field));
                createModal.append(lineSeparator);
            }
            else
            {
                createModal.append("<tr><td>" + field + "</td><td><input id='create" + field + "' type='text' class='form-control' name=\"" + field + "\">.</input></td></tr>");
                createModal.append(lineSeparator);
            }
        }
        createModal.append("<tr><td colspan='2' align='center'>");
        createModal.append(lineSeparator);
        createModal.append("<div class='form-group'><button type='button' class='btn btn-primary' id='add_button' data-dismiss='modal' aria-label='Close'>Add</button></div>");
        createModal.append(lineSeparator);
        createModal.append("</td></tr></table>");
        createModal.append(lineSeparator);
        createModal.append("</form>");
        createModal.append(lineSeparator);
        createModal.append("</div>");
        createModal.append(lineSeparator);
        createModal.append("</div>");
        createModal.append(lineSeparator);
        createModal.append("</div>");


        return createModal.toString();
    }


    public void addConditionModalUpdateCreate(String field, UnaryOperator<String> condition)
    {
        conditionModalUpdateCreate.put(field, condition);
    }


    private String createEditModal()
    {
        StringBuffer editModal = new StringBuffer();

        editModal.append("<div class='modal fade' id='edit-item' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>");
        editModal.append(lineSeparator);
        editModal.append("<div class='modal-content'>");
        editModal.append(lineSeparator);
        editModal.append("<div class='modal-header'>");
        editModal.append(lineSeparator);
        editModal.append("<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>◊</span></button>");
        editModal.append(lineSeparator);
        editModal.append("<h4 class='modal-title' id='myEditLabel'>Edit Item</h4>");
        editModal.append(lineSeparator);
        editModal.append("</div>");
        editModal.append(lineSeparator);
        editModal.append("<div class='modal-body'>");
        editModal.append(lineSeparator);
        editModal.append("<form id='edit_input'>");
        editModal.append(lineSeparator);
        editModal.append("<table class='table table-hover'>");
        editModal.append(lineSeparator);
        for (String field : fields)
        {
            if(conditionModalUpdateCreate.containsKey(field))
            {
                editModal.append(conditionModalUpdateCreate.get(field).apply(field));
                editModal.append(lineSeparator);
            }
            else
            {

                editModal.append("<tr><td>" + field + "</td><td><input id='edit" + field + "' type='text' class='form-control' name=\"" + field + "\">.</input></td></tr>");
                editModal.append(lineSeparator);

            }
        }
        editModal.append("<tr><td colspan='2' align='center'>");
        editModal.append(lineSeparator);
        editModal.append("<div class='form-group'><button type='button' class='btn btn-primary' id='update_button' data-dismiss='modal' aria-label='Close'>Edit</button></div>");
        editModal.append(lineSeparator);
        editModal.append("</td></tr></table>");
        editModal.append(lineSeparator);
        editModal.append("</form>");
        editModal.append(lineSeparator);
        editModal.append("</div>");
        editModal.append(lineSeparator);
        editModal.append("</div>");
        editModal.append(lineSeparator);
        editModal.append("</div>");


        return editModal.toString();
    }

    public void addBodyElement(String bodyElement)
    {
        bodyElements.add(bodyElement);
    }

    private void setBody()
    {

        // the header container
        addBodyElement(createJumbotron());

        // we crate the table
        addBodyElement(createTable(theClass));
        addBodyElement(lineSeparator);

        // we create the create modal
        addBodyElement(createCreateModal());

        // we create the edit modal
        addBodyElement(createEditModal());


    }

    private void setHtml()
    {
        htmlElements = new ArrayList<>();

        htmlElements.add(getHeader());
        htmlElements.add(getBody());

    }


    private String getLibraries()
    {
        StringBuilder htmlLibraries = new StringBuilder();

        for(String library : libraries)
        {
            htmlLibraries.append(library);
            htmlLibraries.append(lineSeparator);
        }

        return htmlLibraries.toString();
    }

    private String getStyle()
    {
        StringBuilder htmlStyle = new StringBuilder();

        htmlStyle.append("<style>");
        htmlStyle.append(lineSeparator);

        for(String style : styles)
        {
            htmlStyle.append(style);
            htmlStyle.append(lineSeparator);
        }

        htmlStyle.append("</style>");
        htmlStyle.append(lineSeparator);

        return htmlStyle.toString();
    }

    private String getScriptVariables()
    {

        StringBuilder htmlScriptVariables = new StringBuilder();
        htmlScriptVariables.append(lineSeparator);

        for(String scriptVariable : scriptVariables)
        {
            htmlScriptVariables.append(scriptVariable);
            htmlScriptVariables.append(lineSeparator);
        }

        return htmlScriptVariables.toString();
    }

    private String getScriptFunctions()
    {

        StringBuilder htmlScriptFunctions = new StringBuilder();
        htmlScriptFunctions.append(lineSeparator);

        for(String scriptFunction : scriptFunctions)
        {
            htmlScriptFunctions.append(scriptFunction);
            htmlScriptFunctions.append(lineSeparator);
        }

        return htmlScriptFunctions.toString();
    }


    private String getScript()
    {
        // we intialize the html builder
        StringBuilder htmlScript = new StringBuilder();

        // we create the js script
        htmlScript.append("<script>");
        htmlScript.append(lineSeparator);


        for(String script : scripts)
        {
            htmlScript.append(script);
        }


        htmlScript.append(lineSeparator);
        htmlScript.append("</script>");
        htmlScript.append(lineSeparator);

        return htmlScript.toString();

    }


    private String getHeader()
    {
        StringBuilder htmlHeaders = new StringBuilder();

        htmlHeaders.append("<head>");
        htmlHeaders.append(lineSeparator);

        for(String header : headers)
        {
            htmlHeaders.append(header);
            htmlHeaders.append(lineSeparator);
        }

        htmlHeaders.append("</head>");
        htmlHeaders.append(lineSeparator);

        return htmlHeaders.toString();
    }

    private String getBody()
    {
        StringBuilder htmlHeaders = new StringBuilder();

        htmlHeaders.append("<body>");
        htmlHeaders.append(lineSeparator);

        for(String bodyElement : bodyElements)
        {
            htmlHeaders.append(bodyElement);
            htmlHeaders.append(lineSeparator);
        }

        htmlHeaders.append("</body>");
        htmlHeaders.append(lineSeparator);

        return htmlHeaders.toString();
    }

    public String getHtml()
    {
        StringBuilder htmlBuilder = new StringBuilder();

        // we initialize the html document
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append(lineSeparator);
        htmlBuilder.append("<html lang='en'>");

        htmlBuilder.append(lineSeparator);

        for(String htmlElement : htmlElements)
        {
            htmlBuilder.append(htmlElement);
            htmlBuilder.append(lineSeparator);
        }

        htmlBuilder.append("</html>");
        htmlBuilder.append(lineSeparator);

        return htmlBuilder.toString();

    }


    private List<String> getFieldNames(Class theClass)
    {
        // we initialize the list of field names
        List<String> fieldNames = new ArrayList<>();

        // we get the fields of the parent
        List<Field> thisFields = Arrays.asList(theClass.getDeclaredFields());

        // we go through the parent fields
        for(Field field : thisFields)
        {
            // we add the name of the field
            fieldNames.add(field.getName());
        }

        // we get the superclass of the class
        Class theSuperclass = theClass.getSuperclass();

        // while the class still has a parent
        while (theSuperclass != null)
        {
            // we get the fields of the parent
            List<Field> parentFields = Arrays.asList(theSuperclass.getDeclaredFields());

            // we go through the parent fields
            for(Field field : parentFields)
            {
                // we add the name of the field
                fieldNames.add(field.getName());
            }

            // we pass to the next superclass
            theSuperclass = theSuperclass.getSuperclass();
        }


        return fieldNames;
    }

    private List<String> getHeaders(Class theClass)
    {
        // we get the field names
        List<String> fieldNames = getFieldNames(theClass);
        // we initialize the table headers
        List<String> headersList = new ArrayList<>();

        // we go through the field names
        for(String field : fieldNames)
        {
            // we create the corresponding header
            String currentHeader = "<th>" + field + "</th>";
            // we add the current header to the headers list
            headersList.add(currentHeader);
        }

        // we return the list of headers
        return headersList;
    }

    private String createTableHeader(Class theClass)
    {
        // we initialize the table header
        String tableHeader = "<thead><tr>";
        tableHeader = tableHeader + lineSeparator;

        // we get the headers
        List<String> headers = getHeaders(theClass);

        // we go though the table headers
        for(String header : headers)
        {
            // we add the current header to the table header
            tableHeader = tableHeader + header + lineSeparator;
        }

        // we create the create button
        tableHeader = tableHeader + "<th><button type='button' class='btn btn-success' data-toggle='modal' data-target='#create-item' id='add_menu_button'>Create Item</button></th>";

        // we create the create button
        tableHeader = tableHeader + "<th><button type='button' class='btn btn-success' id='refresh_menu_button'>Refresh</button></th>";

        // we close the table header
        tableHeader = tableHeader + "</tr>" + lineSeparator + "</thead>";

        // we return the table header
        return tableHeader;
    }

    private String createTableBody()
    {
        // we initialize the table body
        String tableBody = "<tbody></tbody>";

        // we return the table body
        return tableBody;
    }

    private String createTable(Class theClass)
    {
        // we initialize the table
        String table = "<div id='tableContainer'>" +
                "<table id='table" + theClass.getSimpleName() + "' class='table table-boarded table-hover'>";
        table = table + lineSeparator;

        // we add the header
        table = table + createTableHeader(theClass);
        table = table + lineSeparator;

        // we add the body
        table = table + createTableBody();
        table = table + lineSeparator;

        // we close the table
        table = table + "</table>" +
                "</div>";
        table = table + lineSeparator;

        // we return the table
        return table;
    }

    private void writeElementToFile(String fileName, String stringHtml)
    {
        try
        {
            // we open the file
            File file = new File("./src/main/resources/templates/" + fileName + ".html");
            // create new file in case it doesn't
            file.createNewFile();
            // we initialize the file output stream
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // write the json data text bytes to the file
            fileOutputStream.write(stringHtml.getBytes());
            // we close the file stream
            fileOutputStream.close();
        }
        catch (IOException error)
        {
            System.out.println("Could not open file " + fileName + " for writing");
        }

    }


}