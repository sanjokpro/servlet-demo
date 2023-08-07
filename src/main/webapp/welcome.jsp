<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome the JEE Application</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .welcome-container {
            text-align: center;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .welcome-heading {
            font-size: 2rem;
            margin-bottom: 10px;
            color: #333333;
        }

        .welcome-text {
            font-size: 1.2rem;
            color: #666666;
        }

        .welcome-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .welcome-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="welcome-container">
    <h1 class="welcome-heading">Welcome!</h1>
    <p class="welcome-text">We are learning server side programming!.</p>
    <a href="/home" class="welcome-button">Work hard and smart</a>
</div>
</body>
</html>
