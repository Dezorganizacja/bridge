# bridge

## Tools
* Java 8
* JavaFX
* JUnit 4

## Setup

### IntelliJ setup
1. Clone git repository `git clone git@github.com:Dezorganizacja/bridge.git`
2. Import maven project by clicking `File -> Import Project...` and selecting `bridge/pom.xml` file.
3. Run `com.dezorganizacja.bridge.Bridge` class.

### Shell setup

You can probably ignore these steps if you use proper IDE. :)

1. Clone git repository `git clone git@github.com:Dezorganizacja/bridge.git`
2. Compile project using `mvn package`
3. Run `java -jar target/Bridge.jar`

## Contributing

1. We use [Trello](https://trello.com/b/xIddxJPH/main) for tracking features (and bugs) and GitHub Pull Requests to handle code reviews.
2. `master` branch **must always** be stable, usable (i.e. code compiles, app starts...), and all automated **tests must pass**.
3. Each feature (or bug, refactor) requires a separate git branch
4. Code is incorporated (merged) into `master` branch only after 2 code reviews (yes, I actually mean it). You need an "OK" from your peer and one random person (preferably more experienced than you).
5. It's OK to spend a lot of time polishing your Pull Requests. It's much more productive to ease others' work, even if slows you down.
6. Make sure you are listed under "Authors" section of this file. :)
7. Once your branch is merged, delete it from GitHub

### Perfect feature/bugfix/pull request

Do one feature/bugfix at a time. Keep it small, but make sure the change makes sense on its own (smallest logical feature).

Never, ever, mix refactors, bug fixes, and features. Make sure bugfix or refactor is done first (preferably merged), and only then start working on your feature (on a new branch!).

Keep your commit messages small and logical. Make sure the name is descriptive and does not contain only one word like "fix".

**ALWAYS** test your code before creating a pull request. Write and run automated tests, verify manually that the application behaves correctly.

Be nice and patient.

Try to address others' concerns. If they have doubts, your code is not clear enough. Strive to change that.

### Language

* Code, comments in code, commit names - must be in English
* Pull Request titles - prefer English
* Pull Request descriptions and comments, Trello tasks - Polish
* other docs - prefer English

## Testing

No idea.

## Authors

* [Grzegorz Świrski](http://swirski.name)
* Marek Rusinowski
* Wiktor Tendera
