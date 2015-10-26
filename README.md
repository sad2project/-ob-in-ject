[![Kotlin](https://img.shields.io/badge/kotlin-1.0.0--beta--1038-blue.svg)](http://kotlinlang.org)

# (Ob/In)ject

(Ob/In)ject (pronounced simply as "obinject") is a pretty simple kotlin "dependency injection library". I hesitate to call it a framework, and I include quotes around "dependency injection" because it's really more of a system for building factory objects.

The basic idea is that whenever you make one of the factories, it returns the factory object instead of storing it in some IoC container with a string key. You assign that factory object to a val, and then it can be used anywhere, including in the definition of other factories.

Let's see an example:

    class Example
    class Example2(val dep: Example)
    
    val xampl = inject(into{Example()}, asSingleton<Example>())
    val xampl2 = inject(xampl, into{Example2(it)}, asFactory<Example2>())
    
`xampl` is the first factory created. It starts with with a call to `inject()`, which is where all factory definitions start. Inside that call are - in this case - two parameters. The first is a basic factory function wrapped in an `into()` call. What the `into()` call does is transform the factory into an object that `asSingleton()` can use to create the final factory. In this case, it's a factory that will only create one instance and then keep returning that same instance over and over again when asked.

Then it creates another factory assigned to `xampl2`. This uses the other basic version of `inject()` that has three parameters: the arguments, the basic factory, and the transformer. The arguments need to be of the same type as the factories returned by `inject()`, so if you want to use a premade object or basic factory as an argument, you need to wrap it in `valueOf()` or `instanceOf()`, respectively. The use of multiple arguments will be discussed later. The second two parameters are the same as the first example; it takes the basic factory in `into()` and a transformer to make it all into the end product. This time, it creates a simple factory that can be called to receive a new `Example2` object each time.

One note about the basic factory in the second example: It uses the shortened lambda version, using `it`. Currently this code wouldn't actually work due to a bug in the type inference with `it` lambdas. So, either the type parameters `<Example, Example2>` would have to be added to the the `into()` call, or else the lambda would need to be switched to something like `{a -> Example2(a)}`. Hopefully, it can even be shortened to a constructor reference in the future.

##Using the "Container"
Unlike in a typical non-annotation-driven framework, the default use doesn't use a "container" that acts as a map with string keys. Instead, the `val`s defined in the bootstrap file are the key and result all in one. This guarantees that the needed key returns the wanted type, and is actually even in the container in the first place. The compiler will complain otherwise.

##Type Inference
Unfortunately, type inference can't seem to quite figure *all* of 

##Multiple Arguments
To use multiple arguments, connect them with `and()`. For example, `valueOf(2).and(xample).and(instanceOf{ArrayList()})`. Infix notation is being considered for the function, which would make it `valueOf(2) and xample and instanceOf{ArrayList()}` if desired. 

Assuming `Example2` now takes all three of the given arguments, the full line of build code would become:

    val xampl2 = inject(valueOf(2) and xample and instanceOf{ArrayList()}, into{a,b,c -> Example2(a, b, c)}, asFactory<Example2>())
    
###Limits
At this point, there is a limit of 10 for the number of arguments that can be passed in. I actually expect to make that limit more strict down the road (not decided, yet), since classes with many dependencies are generally too complex. It'll also make it easier to create the needed permutations of additional features down the road. 
