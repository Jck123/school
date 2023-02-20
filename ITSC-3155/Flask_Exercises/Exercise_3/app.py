from flask import Flask, render_template, request

student_dict = {"James": "GamingNetwork", "Shannon": "MoviesNStuff"}
app = Flask(__name__)

@app.route('/', methods=["GET", "POST"])
def index():
    if request.method == "POST":
        student_dict[request.form["name"]] = request.form["org"]
    return render_template('home.html')

@app.route('/registry')
def registry():
    return render_template('registry.html', registry=student_dict)