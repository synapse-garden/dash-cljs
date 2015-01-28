# Dash

A dashboard for Mindfork.

# Hacking Dash

You'll need [Leiningen](http://leiningen.org/).

To get started working with Dash, you should be working in the `tests` build.

First, make sure everything is in good shape.

```bash
lein cljsbuild once test
```

Now you can start up the local dev server using figwheel:

```bash
lein figwheel test
```

Direct your browser to [`localhost:3449/index_test.html`](http://localhost:3449/index_test.html).  Happy hacking!  You'll still need to refresh your browser to get some changes.  (WIP)

The Ring server will run on `localhost:3449/testserver`.  (WIP)
