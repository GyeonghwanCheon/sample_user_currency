# currency_user_project
---

## API 명세서

#### 1. 통화 생성

+ 설명 : 통화를 생성합니다.
+ HTTP : POST
+ URL : localhost:8080/currencies
+ 상태 코드 : 200 OK
  ```
  {
      "currencyName" : "달러",
      "exchangeRate" : 900,
      "symbol" : "$"
  }
  ```
  + 에러 코드 : 400 BAD_REQUEST
  ```
  {
      "timestamp": "YYYY-MM-DDTHH:mm:ss",
      "status": 400,
      "error": "Bad Request"      
  }
  ```

---

#### 2. 통화 단건 조회

+ 설명 : 통화 단건을 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/currencies/{id}
+ 상태 코드 : 200 OK
  ```
  {
      "id": 1,
      "currencyName": "달러",
      "exchangeRate": 900.00,
      "symbol": "$"
  }
  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
      "status": 404,
      "error": "NOT_FOUND",
      "code": "NOT_FOUND_CURRENCY",
      "massage": "입력한 통화 ID를 찾을 수 없습니다.",
      "timestamp": "YYYY-MM-DDTHH:mm:ss"   
  }
  ```
  ---

#### 3. 통화 전체 조회

+ 설명 : 통화 전체을 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/currencies
+ 상태 코드 : 200 OK
  ```
  [
      {
          "id": 1,
          "currencyName": "달러",
          "exchangeRate": 900.00,
          "symbol": "$"
      },
      { 
  
          ...
  
      }
  ]
  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
      "timestamp": "YYYY-MM-DDTHH:mm:ss",
      "status": 404,
      "error": "Not Found",
      "trace": "org.springframework.web.servlet.resource.NoResourceFoundException: No static resource currencie.\n\tat org.springframework.web.servlet.resource.ResourceHttpRequestHandler.handleRequest(ResourceHttpRequestHandler.java:585)\n\tat org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter.handle(HttpRequestHandlerAdapter.java:52)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:978)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\n\tat java.base/java.lang.Thread.run(Thread.java:1583)\n",
      "message": "No static resource currencie.",
      "path": "/currencie"  
  }
  ```
  ---

#### 4. 유저 생성

+ 설명 : 유저를 생성합니다.
+ HTTP : POST
+ URL : localhost:8080/users
+ 상태 코드 : 200 OK
  ```

   { 
      "name" : "myoma",
      "email" : "1111@1111.com"
   }

  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
      "timestamp": "YYYY-MM-DDTHH:mm:ss",
      "status": 400,
      "error": "Bad Request",
    
      ...
    
      "defaultMessage": "이름의 글자 수는 1~20개 사이여야 합니다.",  
  }
  ```
  ---

#### 5. 특정 유저 조회

+ 설명 : 특정 유저를 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/users/{id}
+ 상태 코드 : 200 OK
  ```

   { 
      "name" : "myoma",
      "email" : "1111@1111.com"
   }

  ```
  + 에러 코드 : 500 Internal Server Error
  ```
  {
      "timestamp": "YYYY-MM-DDTHH:mm:ss",
      "status": 500,
      "error": "Internal Server Error",
      "trace": "java.lang.IllegalArgumentException: 사용자를 찾을 수 없습니다.\n\tat com.sparta.currency_user.service.UserService.lambda$findUserById$0(UserService.java:23)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:403)\n\tat com.sparta.currency_user.service.UserService.findUserById(UserService.java:23)\n\tat com.sparta.currency_user.service.UserService.findById(UserService.java:19)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:723)\n\tat com.sparta.currency_user.service.UserService$$SpringCGLIB$$0.findById(<generated>)\n\tat com.sparta.currency_user.controller.UserController.findUser(UserController.java:29)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:255)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:188)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:978)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\n\tat java.base/java.lang.Thread.run(Thread.java:1583)\n",
      "message": "사용자를 찾을 수 없습니다.",
      "path": "/users/1"
  }
  ```
  ---

#### 6. 유저 전체 조회

+ 설명 : 유저 전체를 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/users
+ 상태 코드 : 200 OK
  ```

   [
       {
           "id": 1,
           "name": "myoma2",
           "email": "1111@1111.com",
           "created_at": "YYYY-MM-DDTHH:mm:ss",
           "modified_at": "YYYY-MM-DDTHH:mm:ss"
       },
       {
           "id": 2,
           "name": "myoma",
           "email": "1111@1111.com",
           "created_at": "YYYY-MM-DDTHH:mm:ss",
           "modified_at": "YYYY-MM-DDTHH:mm:ss"
       }
   ]

  ```
  + 에러 코드 : 500 Internal Server Error
  ```
  {
      "timestamp": "YYYY-MM-DDTHH:mm:ss",
      "status": 500,
      "error": "Internal Server Error",
      "trace": "java.lang.IllegalArgumentException: 사용자를 찾을 수 없습니다.\n\tat com.sparta.currency_user.service.UserService.lambda$findUserById$0(UserService.java:23)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:403)\n\tat com.sparta.currency_user.service.UserService.findUserById(UserService.java:23)\n\tat com.sparta.currency_user.service.UserService.findById(UserService.java:19)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:723)\n\tat com.sparta.currency_user.service.UserService$$SpringCGLIB$$0.findById(<generated>)\n\tat com.sparta.currency_user.controller.UserController.findUser(UserController.java:29)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:255)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:188)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:978)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\n\tat java.base/java.lang.Thread.run(Thread.java:1583)\n",
      "message": "사용자를 찾을 수 없습니다.",
      "path": "/users/1"
  }
  ```
  ---

#### 7. 유저 삭제

+ 설명 : 유저를 삭제합니다.
+ HTTP : DELETE
+ URL : localhost:8080/users/{id}
+ 상태 코드 : 200 OK
  ```
  정상적으로 삭제되었습니다.

  ```
  + 에러 코드 : 500 Internal Server Error
  ```
  {
     "timestamp": "YYYY-MM-DDTHH:mm:ss",
     "status": 500,
     "error": "Internal Server Error",
     "trace": "java.lang.IllegalArgumentException: 사용자를 찾을 수 없습니다.\n\tat com.sparta.currency_user.service.UserService.lambda$findUserById$0(UserService.java:23)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:403)\n\tat com.sparta.currency_user.service.UserService.findUserById(UserService.java:23)\n\tat com.sparta.currency_user.service.UserService.deleteUserById(UserService.java:38)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:380)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:727)\n\tat com.sparta.currency_user.service.UserService$$SpringCGLIB$$0.deleteUserById(<generated>)\n\tat com.sparta.currency_user.controller.UserController.deleteUser(UserController.java:41)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:255)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:188)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:978)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\n\tat org.springframework.web.servlet.FrameworkServlet.doDelete(FrameworkServlet.java:936)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:596)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\n\tat java.base/java.lang.Thread.run(Thread.java:1583)\n",
     "message": "사용자를 찾을 수 없습니다.",
     "path": "/users/3"
  }
  ```
  ---

#### 8. 환전 요청

+ 설명 : 유저, 통화의 정보를 받아와 금액을 환전해줍니다.
+ HTTP : POST
+ URL : localhost:8080/exchanges
+ 상태 코드 : 200 OK
  ```
  {
      "userid" : 1,
      "currencyid" : 1,
      "amountInKrw" : 10000
  }

  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
     "status": 404,
     "error": "NOT_FOUND",
     "code": "NOT_FOUND_USER",
     "massage": "입력한 유저 ID를 찾을 수 없습니다.",
     "timestamp": "YYYY-MM-DDTHH:mm:ss"
  }
  ```
  ```
  {
     "status": 404,
     "error": "NOT_FOUND",
     "code": "NOT_FOUND_CURRENCY",
     "massage": "입력한 통화 ID를 찾을 수 없습니다.",
     "timestamp": "YYYY-MM-DDTHH:mm:ss"
  }
  ```

  ---
#### 9. 특정 고객 환불 조회

+ 설명 : 특정 고객 환불 요청을 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/exchanges/{userid}
+ 상태 코드 : 200 OK
  ```
  [
      {
          "id": 1,
          "userName": "myoma",
          "currencyName": "달러",
          "amountInKrw": 10000.00,
          "amountAfterExchange": 11.11,
          "status": "NORMAL"
      },
      {
         ...
      }
  ]

  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
     "status": 404,
     "error": "NOT_FOUND",
     "code": "NOT_FOUND_USER",
     "massage": "입력한 유저 ID를 찾을 수 없습니다.",
     "timestamp": "YYYY-MM-DDTHH:mm:ss"
  }
  ```
  ---

#### 10. 환불 요청 상태 변경

+ 설명 : 특정 고객 환불 요청을 조회합니다.
+ HTTP : GET
+ URL : localhost:8080/exchanges/{userCurrencyid}
+ 상태 코드 : 200 OK
  ```
  1
  // 상태 변경한 환불 데이터 조회시 status = "CANCELED" 로 변경되어있음.

  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
     "status": 404,
     "error": "NOT_FOUND",
     "code": "NOT_FOUND_USER_CERRENCY",
     "massage": "입력한 환불 요청 정보를 찾을 수 없습니다.",
     "timestamp": "YYYY-MM-DDTHH:mm:ss"
  }
  ```
  ---

#### 11. 고객의 환전 총 금액

+ 설명 : 특정 고객의 환전 횟수, 환전 한 총 금액 조회
+ HTTP : GET
+ URL : localhost:8080/exchanges/sumExchange/{userid}
+ 상태 코드 : 200 OK
  ```
  {
     "count": 3,
     "totalAmountInKrw": 52000.00
  }

  ```
  + 에러 코드 : 404 NOT_FOUND
  ```
  {
     "status": 404,
     "error": "NOT_FOUND",
     "code": "NOT_FOUND_USER",
     "massage": "입력한 유저 ID를 찾을 수 없습니다.",
     "timestamp": "YYYY-MM-DDTHH:mm:ss"
  }
  ```
  ---

## ERD
![ERD_IMAGE](https://github.com/user-attachments/assets/8ea5bf4c-fb6c-478f-92bd-799d0a09f90a)


---

## SQL
![SQL_IMAGE](https://github.com/user-attachments/assets/1b07d3a3-00c4-4d58-8948-c7b3f119006e)
![SQL_IMAGE2](https://github.com/user-attachments/assets/1fcdc053-b198-4c51-942f-3f36a9a8f158)
![SQL_IMAGE3](https://github.com/user-attachments/assets/27cc6f56-cf9c-4e7a-8958-438fe7bbeb89)

---

## 1.프로젝트명 : Currency_User (통화 환전 API)

---

## 2.프로젝트 설명
+ 유저를 생성, 조회, 삭제하며 통화를 생성하고 유저의 금액을 환전해주는 프로그램으로 환율 검증 및 예외처리가 되어있다.
  + Lv_1 기능
    + 유저 생성
    + 유저 삭제
    + 유저 단건 조회
    + 유저 전체 조회
    + 통화 생성
    + 통화 단건 조회
    + 통화 전체 조회
  + Lv_2 기능
    + 환전 요청 기능
    + 특정 고객 환전 조회
    + 환전 요청 상태 변경
  + Lv_5 기능
    + 고객의 환전 총 금액 및 횟수


---

## 3.프로젝트 설치 및 실행 방법
+ JAVA IDEA 프로그램 설치, JAVA 설치
+ Spring IDEA 프로그램 설치
+ JAVA 버전 확인
+ mysql DB 설치
+ postman 사용
+ 관련 dependencies 확인
+ 코드 클론 후 사용

---

## 4.프로젝트 사용 방법
+ 개인 DB 설정
+ 프로그램 실행 후 서버가 정상적으로 작동하는 지 확인
+ API 명세서 확인
+ postman을 통해 URL 및 JSON 작성

---

## 5.참고자료
+ https://jsonobject.tistory.com/466
+ https://programmingrecoding.tistory.com/13
+ https://velog.io/@minji/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-Spring-Boot%EC%9D%98-Validation-Valid-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9C%BC%EB%A1%9C-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%A6%9D%ED%95%98%EA%B8%B0
+ https://ehdals9412.tistory.com/42
---

+ Version : 1.0





