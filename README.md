# ronda-routing-schema

Combines [ronda/routing][routing] and [ronda/schema][schema] to provide
request/response schema validation based on `RouteDescriptor` metadata.

## Usage

__Leiningen__ ([via Clojars](https://clojars.org/ronda/routing-schema))

[![Clojars
Project](http://clojars.org/ronda/routing-schema/latest-version.svg)](http://clojars.org/ronda/routing-schema)

__REPL__

Generate a [`RouteDescriptor`][descriptor] and a [request/response
schema][schema], then connect the two:

```clojure
(require '[ronda.routing.schema :as schema])

(def descriptor-with-schema
  (-> descriptor
      (schema/enable-schema :route1 schema1)
      (schema/enable-schema :route2 schema2)))
```

Afterwards, add the descriptor-based validation middleware to your stack:

```clojure
(def app-with-schema
  (-> app
      (schema/wrap-schemas)
      ...
      (ronda.routing/wrap-routing descriptor-with-schema)))
```

## License

```
The MIT License (MIT)

Copyright (c) 2015 Yannick Scherer

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

[descriptor]: https://github.com/xsc/ronda-routing#route-descriptors
[routing]: https://github.com/xsc/ronda-routing
[schema]: https://github.com/xsc/ronda-schema
