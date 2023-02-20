from flask import Flask, render_template
import datetime

app = Flask(__name__)

@app.route('/')
def index():
        return render_template('home.html', time=datetime.datetime.now().strftime("%A, %B %d %Y %H:%M:%S"))