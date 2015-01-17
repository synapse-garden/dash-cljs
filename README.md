# Dash

A dashboard for Mindfork.

# Hacking Dash

To get started using Dash, you should be working in the `tests` build.

 > Make sure everything is in good shape first.

```bash
lein cljsbuild once test
```

Now you can start up the local server using figwheel:

```bash
lein figwheel test
```

You can now direct your browser to [`localhost:3449/index_test.html`](http://localhost:3449/index_test.html) and
start hacking.  You'll still need to refresh your browser to get some changes.  (WIP)
