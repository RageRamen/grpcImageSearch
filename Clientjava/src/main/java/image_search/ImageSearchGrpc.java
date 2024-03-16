package image_search;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: src/main/java/image_search.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ImageSearchGrpc {

  private ImageSearchGrpc() {}

  public static final java.lang.String SERVICE_NAME = "image_search.ImageSearch";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<image_search.SearchRequest,
      image_search.ImageResponse> getSearchImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchImage",
      requestType = image_search.SearchRequest.class,
      responseType = image_search.ImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<image_search.SearchRequest,
      image_search.ImageResponse> getSearchImageMethod() {
    io.grpc.MethodDescriptor<image_search.SearchRequest, image_search.ImageResponse> getSearchImageMethod;
    if ((getSearchImageMethod = ImageSearchGrpc.getSearchImageMethod) == null) {
      synchronized (ImageSearchGrpc.class) {
        if ((getSearchImageMethod = ImageSearchGrpc.getSearchImageMethod) == null) {
          ImageSearchGrpc.getSearchImageMethod = getSearchImageMethod =
              io.grpc.MethodDescriptor.<image_search.SearchRequest, image_search.ImageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchImage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  image_search.SearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  image_search.ImageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ImageSearchMethodDescriptorSupplier("SearchImage"))
              .build();
        }
      }
    }
    return getSearchImageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImageSearchStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageSearchStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ImageSearchStub>() {
        @java.lang.Override
        public ImageSearchStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ImageSearchStub(channel, callOptions);
        }
      };
    return ImageSearchStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImageSearchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageSearchBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ImageSearchBlockingStub>() {
        @java.lang.Override
        public ImageSearchBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ImageSearchBlockingStub(channel, callOptions);
        }
      };
    return ImageSearchBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImageSearchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageSearchFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ImageSearchFutureStub>() {
        @java.lang.Override
        public ImageSearchFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ImageSearchFutureStub(channel, callOptions);
        }
      };
    return ImageSearchFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void searchImage(image_search.SearchRequest request,
        io.grpc.stub.StreamObserver<image_search.ImageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchImageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ImageSearch.
   */
  public static abstract class ImageSearchImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ImageSearchGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ImageSearch.
   */
  public static final class ImageSearchStub
      extends io.grpc.stub.AbstractAsyncStub<ImageSearchStub> {
    private ImageSearchStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageSearchStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageSearchStub(channel, callOptions);
    }

    /**
     */
    public void searchImage(image_search.SearchRequest request,
        io.grpc.stub.StreamObserver<image_search.ImageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchImageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ImageSearch.
   */
  public static final class ImageSearchBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ImageSearchBlockingStub> {
    private ImageSearchBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageSearchBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageSearchBlockingStub(channel, callOptions);
    }

    /**
     */
    public image_search.ImageResponse searchImage(image_search.SearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchImageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ImageSearch.
   */
  public static final class ImageSearchFutureStub
      extends io.grpc.stub.AbstractFutureStub<ImageSearchFutureStub> {
    private ImageSearchFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageSearchFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageSearchFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<image_search.ImageResponse> searchImage(
        image_search.SearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchImageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_IMAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_IMAGE:
          serviceImpl.searchImage((image_search.SearchRequest) request,
              (io.grpc.stub.StreamObserver<image_search.ImageResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSearchImageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              image_search.SearchRequest,
              image_search.ImageResponse>(
                service, METHODID_SEARCH_IMAGE)))
        .build();
  }

  private static abstract class ImageSearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImageSearchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return image_search.ImageSearchOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImageSearch");
    }
  }

  private static final class ImageSearchFileDescriptorSupplier
      extends ImageSearchBaseDescriptorSupplier {
    ImageSearchFileDescriptorSupplier() {}
  }

  private static final class ImageSearchMethodDescriptorSupplier
      extends ImageSearchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ImageSearchMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ImageSearchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImageSearchFileDescriptorSupplier())
              .addMethod(getSearchImageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
