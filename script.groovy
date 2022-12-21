def buildApp() {
    echo "App in build stage"
}

def stageApp() {
    echo "App in staging stage"
}

def deployApp() {
    echo "App in staging stage"
}

def python() {
    sh "python3 app.py"
}

return this
