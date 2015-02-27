# ronda-routing-schema

Combines [ronda/routing][routing] and [ronda/schema][schema] to provide
request/response schema validation based on `RouteDescriptor` metadata.

## Usage

__Leiningen__ ([via Clojars](https://clojars.org/ronda/routing-schema)

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

Copyright &copy; 2015 Yannick Scherer

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

[routing]: https://github.com/xsc/ronda-routing
[schema]: https://github.com/xsc/ronda-schema
