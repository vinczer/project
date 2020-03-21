<!DOCTYPE html>
<html>
    <head>
        <title>Authors</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"
    </head>

    <body>
        <div>
            <form method="post" action="/authors/add">
                <input type="text" id="firstName" name="firstName" placeholder="First name" />
            	<input type="text" id="lastName" name="lastName" placeholder="Last name"  />
                <button type="submit" class="btn btn-primary">Add</button>
            </form>

            </br>

            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <#list model["authors"] as author>
                    <tr>
                        <td>${author.id}</td>
                        <td>${author.firstName}</td>
                        <td>${author.lastName}</td>
                        <td><a role="button" href="/authors/delete/${author.id}">Delete</a></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </body>
</html>