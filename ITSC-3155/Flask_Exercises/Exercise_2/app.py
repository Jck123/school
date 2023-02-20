from flask import Flask, render_template

app = Flask(__name__)

@app.route("/")
def index():
    return render_template('home.html')

@app.route("/process")
def process():
    return render_template('intStuff.html')