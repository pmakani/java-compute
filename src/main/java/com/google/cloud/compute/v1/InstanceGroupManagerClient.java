/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.InstanceGroupManagerStub;
import com.google.cloud.compute.v1.stub.InstanceGroupManagerStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Creates and runs virtual machines on Google Cloud Platform.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
 *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
 *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
 *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the instanceGroupManagerClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of InstanceGroupManagerSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * InstanceGroupManagerSettings instanceGroupManagerSettings =
 *     InstanceGroupManagerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * InstanceGroupManagerClient instanceGroupManagerClient =
 *     InstanceGroupManagerClient.create(instanceGroupManagerSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * InstanceGroupManagerSettings instanceGroupManagerSettings =
 *     InstanceGroupManagerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * InstanceGroupManagerClient instanceGroupManagerClient =
 *     InstanceGroupManagerClient.create(instanceGroupManagerSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstanceGroupManagerClient implements BackgroundResource {
  private final InstanceGroupManagerSettings settings;
  private final InstanceGroupManagerStub stub;

  /** Constructs an instance of InstanceGroupManagerClient with default settings. */
  public static final InstanceGroupManagerClient create() throws IOException {
    return create(InstanceGroupManagerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final InstanceGroupManagerClient create(InstanceGroupManagerSettings settings)
      throws IOException {
    return new InstanceGroupManagerClient(settings);
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given stub for making calls.
   * This is for advanced usage - prefer to use InstanceGroupManagerSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final InstanceGroupManagerClient create(InstanceGroupManagerStub stub) {
    return new InstanceGroupManagerClient(stub);
  }

  /**
   * Constructs an instance of InstanceGroupManagerClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected InstanceGroupManagerClient(InstanceGroupManagerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((InstanceGroupManagerStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected InstanceGroupManagerClient(InstanceGroupManagerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final InstanceGroupManagerSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstanceGroupManagerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {
    AbandonInstancesInstanceGroupManagerHttpRequest request =
        AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersAbandonInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersAbandonInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersAbandonInstancesRequest
          instanceGroupManagersAbandonInstancesRequestResource) {
    AbandonInstancesInstanceGroupManagerHttpRequest request =
        AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersAbandonInstancesRequestResource(
                instanceGroupManagersAbandonInstancesRequestResource)
            .build();
    return abandonInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesInstanceGroupManagerHttpRequest request = AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.abandonInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation abandonInstancesInstanceGroupManager(
      AbandonInstancesInstanceGroupManagerHttpRequest request) {
    return abandonInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances to be removed from the managed instance group. Abandoning an
   * instance does not delete the instance, but it does remove the instance from any target pools
   * that are applied by the managed instance group. This method reduces the targetSize of the
   * managed instance group by the number of instances that you abandon. This operation is marked as
   * DONE when the action is scheduled even if the instances have not yet been removed from the
   * group. You must separately verify the status of the abandoning action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersAbandonInstancesRequest instanceGroupManagersAbandonInstancesRequestResource = InstanceGroupManagersAbandonInstancesRequest.newBuilder().build();
   *   AbandonInstancesInstanceGroupManagerHttpRequest request = AbandonInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersAbandonInstancesRequestResource(instanceGroupManagersAbandonInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.abandonInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerCallable() {
    return stub.abandonInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Boolean includeAllScopes = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(includeAllScopes, project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param includeAllScopes Indicates whether every visible scope for each scope type (zone,
   *     region, global) should be included in the response. For new resource types added after this
   *     field, the flag has no effect as new resource types will always include every visible scope
   *     for each scope type in response. For resource types which predate this field, if this flag
   *     is omitted or false, only scopes of the scope types where the resource type is expected to
   *     be found will be included.
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      Boolean includeAllScopes, ProjectName project) {
    AggregatedListInstanceGroupManagersHttpRequest request =
        AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
            .setIncludeAllScopes(includeAllScopes)
            .setProject(project == null ? null : project.toString())
            .build();
    return aggregatedListInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Boolean includeAllScopes = false;
   *   ProjectName project = ProjectName.of("[PROJECT]");
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(includeAllScopes, project.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param includeAllScopes Indicates whether every visible scope for each scope type (zone,
   *     region, global) should be included in the response. For new resource types added after this
   *     field, the flag has no effect as new resource types will always include every visible scope
   *     for each scope type in response. For resource types which predate this field, if this flag
   *     is omitted or false, only scopes of the scope types where the resource type is expected to
   *     be found will be included.
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      Boolean includeAllScopes, String project) {
    AggregatedListInstanceGroupManagersHttpRequest request =
        AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
            .setIncludeAllScopes(includeAllScopes)
            .setProject(project)
            .build();
    return aggregatedListInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   for (InstanceGroupManagersScopedList element : instanceGroupManagerClient.aggregatedListInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final AggregatedListInstanceGroupManagersPagedResponse aggregatedListInstanceGroupManagers(
      AggregatedListInstanceGroupManagersHttpRequest request) {
    return aggregatedListInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   ApiFuture&lt;AggregatedListInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.aggregatedListInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManagersScopedList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest,
          AggregatedListInstanceGroupManagersPagedResponse>
      aggregatedListInstanceGroupManagersPagedCallable() {
    return stub.aggregatedListInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of managed instance groups and groups them by zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Boolean includeAllScopes = false;
   *   String formattedProject = ProjectName.format("[PROJECT]");
   *   AggregatedListInstanceGroupManagersHttpRequest request = AggregatedListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setIncludeAllScopes(includeAllScopes)
   *     .setProject(formattedProject)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerAggregatedList response = instanceGroupManagerClient.aggregatedListInstanceGroupManagersCallable().call(request);
   *     for (InstanceGroupManagersScopedList element : response.getItemsMap()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
      aggregatedListInstanceGroupManagersCallable() {
    return stub.aggregatedListInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.applyUpdatesToInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersApplyUpdatesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group, should conform to RFC1035.
   * @param instanceGroupManagersApplyUpdatesRequestResource
   *     InstanceGroupManagers.applyUpdatesToInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation applyUpdatesToInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource) {
    ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest request =
        ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersApplyUpdatesRequestResource(
                instanceGroupManagersApplyUpdatesRequestResource)
            .build();
    return applyUpdatesToInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.applyUpdatesToInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersApplyUpdatesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group, should conform to RFC1035.
   * @param instanceGroupManagersApplyUpdatesRequestResource
   *     InstanceGroupManagers.applyUpdatesToInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation applyUpdatesToInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource) {
    ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest request =
        ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersApplyUpdatesRequestResource(
                instanceGroupManagersApplyUpdatesRequestResource)
            .build();
    return applyUpdatesToInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest request = ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersApplyUpdatesRequestResource(instanceGroupManagersApplyUpdatesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.applyUpdatesToInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation applyUpdatesToInstancesInstanceGroupManager(
      ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest request) {
    return applyUpdatesToInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Applies changes to selected instances on the managed instance group. This method can be used to
   * apply new overrides and/or new versions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersApplyUpdatesRequest instanceGroupManagersApplyUpdatesRequestResource = InstanceGroupManagersApplyUpdatesRequest.newBuilder().build();
   *   ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest request = ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersApplyUpdatesRequestResource(instanceGroupManagersApplyUpdatesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.applyUpdatesToInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>
      applyUpdatesToInstancesInstanceGroupManagerCallable() {
    return stub.applyUpdatesToInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.createInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersCreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersCreateInstancesRequestResource
   *     InstanceGroupManagers.createInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersCreateInstancesRequest
          instanceGroupManagersCreateInstancesRequestResource) {
    CreateInstancesInstanceGroupManagerHttpRequest request =
        CreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersCreateInstancesRequestResource(
                instanceGroupManagersCreateInstancesRequestResource)
            .build();
    return createInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.createInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersCreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersCreateInstancesRequestResource
   *     InstanceGroupManagers.createInstances
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersCreateInstancesRequest
          instanceGroupManagersCreateInstancesRequestResource) {
    CreateInstancesInstanceGroupManagerHttpRequest request =
        CreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersCreateInstancesRequestResource(
                instanceGroupManagersCreateInstancesRequestResource)
            .build();
    return createInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   CreateInstancesInstanceGroupManagerHttpRequest request = CreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersCreateInstancesRequestResource(instanceGroupManagersCreateInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.createInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation createInstancesInstanceGroupManager(
      CreateInstancesInstanceGroupManagerHttpRequest request) {
    return createInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates instances with per-instance configs in this managed instance group. Instances are
   * created using the current instance template. The create instances operation is marked DONE if
   * the createInstances request is successful. The underlying actions take additional time. You
   * must separately verify the status of the creating or actions with the listmanagedinstances
   * method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersCreateInstancesRequest instanceGroupManagersCreateInstancesRequestResource = InstanceGroupManagersCreateInstancesRequest.newBuilder().build();
   *   CreateInstancesInstanceGroupManagerHttpRequest request = CreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersCreateInstancesRequestResource(instanceGroupManagersCreateInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.createInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<CreateInstancesInstanceGroupManagerHttpRequest, Operation>
      createInstancesInstanceGroupManagerCallable() {
    return stub.createInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    DeleteInstanceGroupManagerHttpRequest request =
        DeleteInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return deleteInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(String instanceGroupManager) {
    DeleteInstanceGroupManagerHttpRequest request =
        DeleteInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return deleteInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteInstanceGroupManagerHttpRequest request = DeleteInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   Operation response = instanceGroupManagerClient.deleteInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstanceGroupManager(DeleteInstanceGroupManagerHttpRequest request) {
    return deleteInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified managed instance group and all of the instances in that group. Note that
   * the instance group must not belong to a backend service. Read Deleting an instance group for
   * more information.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   DeleteInstanceGroupManagerHttpRequest request = DeleteInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.deleteInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerCallable() {
    return stub.deleteInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {
    DeleteInstancesInstanceGroupManagerHttpRequest request =
        DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersDeleteInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersDeleteInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersDeleteInstancesRequest
          instanceGroupManagersDeleteInstancesRequestResource) {
    DeleteInstancesInstanceGroupManagerHttpRequest request =
        DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeleteInstancesRequestResource(
                instanceGroupManagersDeleteInstancesRequestResource)
            .build();
    return deleteInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesInstanceGroupManagerHttpRequest request = DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.deleteInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deleteInstancesInstanceGroupManager(
      DeleteInstancesInstanceGroupManagerHttpRequest request) {
    return deleteInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group for immediate deletion. The
   * instances are also removed from any target pools of which they were a member. This method
   * reduces the targetSize of the managed instance group by the number of instances that you
   * delete. This operation is marked as DONE when the action is scheduled even if the instances are
   * still being deleted. You must separately verify the status of the deleting action with the
   * listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeleteInstancesRequest instanceGroupManagersDeleteInstancesRequestResource = InstanceGroupManagersDeleteInstancesRequest.newBuilder().build();
   *   DeleteInstancesInstanceGroupManagerHttpRequest request = DeleteInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersDeleteInstancesRequestResource(instanceGroupManagersDeleteInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.deleteInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerCallable() {
    return stub.deleteInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deletePerInstanceConfigsInstanceGroupManager(instanceGroupManager, instanceGroupManagersDeletePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersDeletePerInstanceConfigsReqResource
   *     InstanceGroupManagers.deletePerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePerInstanceConfigsInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersDeletePerInstanceConfigsReq
          instanceGroupManagersDeletePerInstanceConfigsReqResource) {
    DeletePerInstanceConfigsInstanceGroupManagerHttpRequest request =
        DeletePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
                instanceGroupManagersDeletePerInstanceConfigsReqResource)
            .build();
    return deletePerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.deletePerInstanceConfigsInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersDeletePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersDeletePerInstanceConfigsReqResource
   *     InstanceGroupManagers.deletePerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePerInstanceConfigsInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersDeletePerInstanceConfigsReq
          instanceGroupManagersDeletePerInstanceConfigsReqResource) {
    DeletePerInstanceConfigsInstanceGroupManagerHttpRequest request =
        DeletePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(
                instanceGroupManagersDeletePerInstanceConfigsReqResource)
            .build();
    return deletePerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   DeletePerInstanceConfigsInstanceGroupManagerHttpRequest request = DeletePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(instanceGroupManagersDeletePerInstanceConfigsReqResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.deletePerInstanceConfigsInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation deletePerInstanceConfigsInstanceGroupManager(
      DeletePerInstanceConfigsInstanceGroupManagerHttpRequest request) {
    return deletePerInstanceConfigsInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes selected per-instance configs for the managed instance group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersDeletePerInstanceConfigsReq instanceGroupManagersDeletePerInstanceConfigsReqResource = InstanceGroupManagersDeletePerInstanceConfigsReq.newBuilder().build();
   *   DeletePerInstanceConfigsInstanceGroupManagerHttpRequest request = DeletePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersDeletePerInstanceConfigsReqResource(instanceGroupManagersDeletePerInstanceConfigsReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.deletePerInstanceConfigsInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      deletePerInstanceConfigsInstanceGroupManagerCallable() {
    return stub.deletePerInstanceConfigsInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    GetInstanceGroupManagerHttpRequest request =
        GetInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return getInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(String instanceGroupManager) {
    GetInstanceGroupManagerHttpRequest request =
        GetInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return getInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   GetInstanceGroupManagerHttpRequest request = GetInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   InstanceGroupManager response = instanceGroupManagerClient.getInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final InstanceGroupManager getInstanceGroupManager(
      GetInstanceGroupManagerHttpRequest request) {
    return getInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns all of the details about the specified managed instance group. Gets a list of available
   * managed instance groups by making a list() request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   GetInstanceGroupManagerHttpRequest request = GetInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;InstanceGroupManager&gt; future = instanceGroupManagerClient.getInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   InstanceGroupManager response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerCallable() {
    return stub.getInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(zone, instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource Represents a Managed Instance Group resource.
   *     <p>An instance group is a collection of VM instances that you can manage as a single
   *     entity. For more information, read Instance groups.
   *     <p>For zonal Managed Instance Group, use the instanceGroupManagers resource.
   *     <p>For regional Managed Instance Group, use the regionInstanceGroupManagers resource. (==
   *     resource_for {$api_version}.instanceGroupManagers ==) (== resource_for
   *     {$api_version}.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(
      ProjectZoneName zone, InstanceGroupManager instanceGroupManagerResource) {
    InsertInstanceGroupManagerHttpRequest request =
        InsertInstanceGroupManagerHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(zone.toString(), instanceGroupManagerResource);
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where you want to create the managed instance group.
   * @param instanceGroupManagerResource Represents a Managed Instance Group resource.
   *     <p>An instance group is a collection of VM instances that you can manage as a single
   *     entity. For more information, read Instance groups.
   *     <p>For zonal Managed Instance Group, use the instanceGroupManagers resource.
   *     <p>For regional Managed Instance Group, use the regionInstanceGroupManagers resource. (==
   *     resource_for {$api_version}.instanceGroupManagers ==) (== resource_for
   *     {$api_version}.regionInstanceGroupManagers ==)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(
      String zone, InstanceGroupManager instanceGroupManagerResource) {
    InsertInstanceGroupManagerHttpRequest request =
        InsertInstanceGroupManagerHttpRequest.newBuilder()
            .setZone(zone)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .build();
    return insertInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertInstanceGroupManagerHttpRequest request = InsertInstanceGroupManagerHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.insertInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation insertInstanceGroupManager(InsertInstanceGroupManagerHttpRequest request) {
    return insertInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a managed instance group using the information that you specify in the request. After
   * the group is created, instances in the group are created using the specified instance template.
   * This operation is marked as DONE when the group is created even if the instances in the group
   * have not yet been created. You must separately verify the status of the individual instances
   * with the listmanagedinstances method.
   *
   * <p>A managed instance group can have up to 1000 VM instances per group. Please contact Cloud
   * Support if you need an increase in this limit.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   InsertInstanceGroupManagerHttpRequest request = InsertInstanceGroupManagerHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.insertInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerCallable() {
    return stub.insertInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(zone).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(
      ProjectZoneName zone) {
    ListInstanceGroupManagersHttpRequest request =
        ListInstanceGroupManagersHttpRequest.newBuilder()
            .setZone(zone == null ? null : zone.toString())
            .build();
    return listInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneName zone = ProjectZoneName.of("[PROJECT]", "[ZONE]");
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(zone.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param zone The name of the zone where the managed instance group is located.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(String zone) {
    ListInstanceGroupManagersHttpRequest request =
        ListInstanceGroupManagersHttpRequest.newBuilder().setZone(zone).build();
    return listInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   for (InstanceGroupManager element : instanceGroupManagerClient.listInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListInstanceGroupManagersPagedResponse listInstanceGroupManagers(
      ListInstanceGroupManagersHttpRequest request) {
    return listInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   ApiFuture&lt;ListInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.listInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceGroupManager element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListInstanceGroupManagersHttpRequest, ListInstanceGroupManagersPagedResponse>
      listInstanceGroupManagersPagedCallable() {
    return stub.listInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves a list of managed instance groups that are contained within the specified project and
   * zone.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedZone = ProjectZoneName.format("[PROJECT]", "[ZONE]");
   *   ListInstanceGroupManagersHttpRequest request = ListInstanceGroupManagersHttpRequest.newBuilder()
   *     .setZone(formattedZone)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagerList response = instanceGroupManagerClient.listInstanceGroupManagersCallable().call(request);
   *     for (InstanceGroupManager element : response.getItemsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
      listInstanceGroupManagersCallable() {
    return stub.listInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (InstanceManagedByIgmError element : instanceGroupManagerClient.listErrorsInstanceGroupManagers(instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It must be a string that
   *     meets the requirements in RFC1035, or an unsigned long integer: must match regexp pattern:
   *     (?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)|[1-9][0-9]{0,19}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListErrorsInstanceGroupManagersPagedResponse listErrorsInstanceGroupManagers(
      ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    ListErrorsInstanceGroupManagersHttpRequest request =
        ListErrorsInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return listErrorsInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (InstanceManagedByIgmError element : instanceGroupManagerClient.listErrorsInstanceGroupManagers(instanceGroupManager.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It must be a string that
   *     meets the requirements in RFC1035, or an unsigned long integer: must match regexp pattern:
   *     (?:[a-z](?:[-a-z0-9]{0,61}[a-z0-9])?)|[1-9][0-9]{0,19}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListErrorsInstanceGroupManagersPagedResponse listErrorsInstanceGroupManagers(
      String instanceGroupManager) {
    ListErrorsInstanceGroupManagersHttpRequest request =
        ListErrorsInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listErrorsInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListErrorsInstanceGroupManagersHttpRequest request = ListErrorsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   for (InstanceManagedByIgmError element : instanceGroupManagerClient.listErrorsInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListErrorsInstanceGroupManagersPagedResponse listErrorsInstanceGroupManagers(
      ListErrorsInstanceGroupManagersHttpRequest request) {
    return listErrorsInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListErrorsInstanceGroupManagersHttpRequest request = ListErrorsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;ListErrorsInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.listErrorsInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (InstanceManagedByIgmError element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, ListErrorsInstanceGroupManagersPagedResponse>
      listErrorsInstanceGroupManagersPagedCallable() {
    return stub.listErrorsInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all errors thrown by actions on instances for a given managed instance group. The filter
   * and orderBy query parameters are not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListErrorsInstanceGroupManagersHttpRequest request = ListErrorsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListErrorsResponse response = instanceGroupManagerClient.listErrorsInstanceGroupManagersCallable().call(request);
   *     for (InstanceManagedByIgmError element : response.getItemsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsInstanceGroupManagersCallable() {
    return stub.listErrorsInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (ManagedInstance element : instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListManagedInstancesInstanceGroupManagersPagedResponse
      listManagedInstancesInstanceGroupManagers(
          ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    ListManagedInstancesInstanceGroupManagersHttpRequest request =
        ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return listManagedInstancesInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (ManagedInstance element : instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(instanceGroupManager.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListManagedInstancesInstanceGroupManagersPagedResponse
      listManagedInstancesInstanceGroupManagers(String instanceGroupManager) {
    ListManagedInstancesInstanceGroupManagersHttpRequest request =
        ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listManagedInstancesInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesInstanceGroupManagersHttpRequest request = ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   for (ManagedInstance element : instanceGroupManagerClient.listManagedInstancesInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListManagedInstancesInstanceGroupManagersPagedResponse
      listManagedInstancesInstanceGroupManagers(
          ListManagedInstancesInstanceGroupManagersHttpRequest request) {
    return listManagedInstancesInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesInstanceGroupManagersHttpRequest request = ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;ListManagedInstancesInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (ManagedInstance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          ListManagedInstancesInstanceGroupManagersPagedResponse>
      listManagedInstancesInstanceGroupManagersPagedCallable() {
    return stub.listManagedInstancesInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the instances in the managed instance group. Each instance in the list has a
   * currentAction, which indicates the action that the managed instance group is performing on the
   * instance. For example, if the group is still creating an instance, the currentAction is
   * CREATING. If a previous action failed, the list displays the errors for that failed action. The
   * orderBy query parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListManagedInstancesInstanceGroupManagersHttpRequest request = ListManagedInstancesInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListManagedInstancesResponse response = instanceGroupManagerClient.listManagedInstancesInstanceGroupManagersCallable().call(request);
   *     for (ManagedInstance element : response.getManagedInstancesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersCallable() {
    return stub.listManagedInstancesInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (PerInstanceConfig element : instanceGroupManagerClient.listPerInstanceConfigsInstanceGroupManagers(instanceGroupManager).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPerInstanceConfigsInstanceGroupManagersPagedResponse
      listPerInstanceConfigsInstanceGroupManagers(
          ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    ListPerInstanceConfigsInstanceGroupManagersHttpRequest request =
        ListPerInstanceConfigsInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return listPerInstanceConfigsInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   for (PerInstanceConfig element : instanceGroupManagerClient.listPerInstanceConfigsInstanceGroupManagers(instanceGroupManager.toString()).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPerInstanceConfigsInstanceGroupManagersPagedResponse
      listPerInstanceConfigsInstanceGroupManagers(String instanceGroupManager) {
    ListPerInstanceConfigsInstanceGroupManagersHttpRequest request =
        ListPerInstanceConfigsInstanceGroupManagersHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return listPerInstanceConfigsInstanceGroupManagers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListPerInstanceConfigsInstanceGroupManagersHttpRequest request = ListPerInstanceConfigsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   for (PerInstanceConfig element : instanceGroupManagerClient.listPerInstanceConfigsInstanceGroupManagers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final ListPerInstanceConfigsInstanceGroupManagersPagedResponse
      listPerInstanceConfigsInstanceGroupManagers(
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest request) {
    return listPerInstanceConfigsInstanceGroupManagersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListPerInstanceConfigsInstanceGroupManagersHttpRequest request = ListPerInstanceConfigsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;ListPerInstanceConfigsInstanceGroupManagersPagedResponse&gt; future = instanceGroupManagerClient.listPerInstanceConfigsInstanceGroupManagersPagedCallable().futureCall(request);
   *   // Do something
   *   for (PerInstanceConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          ListPerInstanceConfigsInstanceGroupManagersPagedResponse>
      listPerInstanceConfigsInstanceGroupManagersPagedCallable() {
    return stub.listPerInstanceConfigsInstanceGroupManagersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all of the per-instance configs defined for the managed instance group. The orderBy query
   * parameter is not supported.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ListPerInstanceConfigsInstanceGroupManagersHttpRequest request = ListPerInstanceConfigsInstanceGroupManagersHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   while (true) {
   *     InstanceGroupManagersListPerInstanceConfigsResp response = instanceGroupManagerClient.listPerInstanceConfigsInstanceGroupManagersCallable().call(request);
   *     for (PerInstanceConfig element : response.getItemsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsInstanceGroupManagersCallable() {
    return stub.listPerInstanceConfigsInstanceGroupManagersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(instanceGroupManager, instanceGroupManagerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource Represents a Managed Instance Group resource.
   *     <p>An instance group is a collection of VM instances that you can manage as a single
   *     entity. For more information, read Instance groups.
   *     <p>For zonal Managed Instance Group, use the instanceGroupManagers resource.
   *     <p>For regional Managed Instance Group, use the regionInstanceGroupManagers resource. (==
   *     resource_for {$api_version}.instanceGroupManagers ==) (== resource_for
   *     {$api_version}.regionInstanceGroupManagers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource,
      List<String> fieldMask) {
    PatchInstanceGroupManagerHttpRequest request =
        PatchInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagerResource, fieldMask);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the instance group manager.
   * @param instanceGroupManagerResource Represents a Managed Instance Group resource.
   *     <p>An instance group is a collection of VM instances that you can manage as a single
   *     entity. For more information, read Instance groups.
   *     <p>For zonal Managed Instance Group, use the instanceGroupManagers resource.
   *     <p>For regional Managed Instance Group, use the regionInstanceGroupManagers resource. (==
   *     resource_for {$api_version}.instanceGroupManagers ==) (== resource_for
   *     {$api_version}.regionInstanceGroupManagers ==)
   * @param fieldMask The fields that should be serialized (even if they have empty values). If the
   *     containing message object has a non-null fieldmask, then all the fields in the field mask
   *     (and only those fields in the field mask) will be serialized. If the containing object does
   *     not have a fieldmask, then only non-empty fields will be serialized.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManager instanceGroupManagerResource,
      List<String> fieldMask) {
    PatchInstanceGroupManagerHttpRequest request =
        PatchInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagerResource(instanceGroupManagerResource)
            .addAllFieldMask(fieldMask)
            .build();
    return patchInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInstanceGroupManagerHttpRequest request = PatchInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   Operation response = instanceGroupManagerClient.patchInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchInstanceGroupManager(PatchInstanceGroupManagerHttpRequest request) {
    return patchInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a managed instance group using the information that you specify in the request. This
   * operation is marked as DONE when the group is patched even if the instances in the group are
   * still in the process of being patched. You must separately verify the status of the individual
   * instances with the listManagedInstances method. This method supports PATCH semantics and uses
   * the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManager instanceGroupManagerResource = InstanceGroupManager.newBuilder().build();
   *   List&lt;String&gt; fieldMask = new ArrayList&lt;&gt;();
   *   PatchInstanceGroupManagerHttpRequest request = PatchInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagerResource(instanceGroupManagerResource)
   *     .addAllFieldMask(fieldMask)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.patchInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerCallable() {
    return stub.patchInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.patchPerInstanceConfigsInstanceGroupManager(instanceGroupManager, instanceGroupManagersPatchPerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersPatchPerInstanceConfigsReqResource
   *     InstanceGroupManagers.patchPerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPerInstanceConfigsInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersPatchPerInstanceConfigsReq
          instanceGroupManagersPatchPerInstanceConfigsReqResource) {
    PatchPerInstanceConfigsInstanceGroupManagerHttpRequest request =
        PatchPerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
                instanceGroupManagersPatchPerInstanceConfigsReqResource)
            .build();
    return patchPerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.patchPerInstanceConfigsInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersPatchPerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersPatchPerInstanceConfigsReqResource
   *     InstanceGroupManagers.patchPerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPerInstanceConfigsInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersPatchPerInstanceConfigsReq
          instanceGroupManagersPatchPerInstanceConfigsReqResource) {
    PatchPerInstanceConfigsInstanceGroupManagerHttpRequest request =
        PatchPerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(
                instanceGroupManagersPatchPerInstanceConfigsReqResource)
            .build();
    return patchPerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   PatchPerInstanceConfigsInstanceGroupManagerHttpRequest request = PatchPerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(instanceGroupManagersPatchPerInstanceConfigsReqResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.patchPerInstanceConfigsInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation patchPerInstanceConfigsInstanceGroupManager(
      PatchPerInstanceConfigsInstanceGroupManagerHttpRequest request) {
    return patchPerInstanceConfigsInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersPatchPerInstanceConfigsReq instanceGroupManagersPatchPerInstanceConfigsReqResource = InstanceGroupManagersPatchPerInstanceConfigsReq.newBuilder().build();
   *   PatchPerInstanceConfigsInstanceGroupManagerHttpRequest request = PatchPerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersPatchPerInstanceConfigsReqResource(instanceGroupManagersPatchPerInstanceConfigsReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.patchPerInstanceConfigsInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      patchPerInstanceConfigsInstanceGroupManagerCallable() {
    return stub.patchPerInstanceConfigsInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(instanceGroupManager, instanceGroupManagersRecreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {
    RecreateInstancesInstanceGroupManagerHttpRequest request =
        RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
            .build();
    return recreateInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersRecreateInstancesRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersRecreateInstancesRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersRecreateInstancesRequest
          instanceGroupManagersRecreateInstancesRequestResource) {
    RecreateInstancesInstanceGroupManagerHttpRequest request =
        RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersRecreateInstancesRequestResource(
                instanceGroupManagersRecreateInstancesRequestResource)
            .build();
    return recreateInstancesInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   RecreateInstancesInstanceGroupManagerHttpRequest request = RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.recreateInstancesInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation recreateInstancesInstanceGroupManager(
      RecreateInstancesInstanceGroupManagerHttpRequest request) {
    return recreateInstancesInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Flags the specified instances in the managed instance group to be immediately recreated. The
   * instances are deleted and recreated using the current instance template for the managed
   * instance group. This operation is marked as DONE when the flag is set even if the instances
   * have not yet been recreated. You must separately verify the status of the recreating action
   * with the listmanagedinstances method.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>You can specify a maximum of 1000 instances with this method per request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersRecreateInstancesRequest instanceGroupManagersRecreateInstancesRequestResource = InstanceGroupManagersRecreateInstancesRequest.newBuilder().build();
   *   RecreateInstancesInstanceGroupManagerHttpRequest request = RecreateInstancesInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersRecreateInstancesRequestResource(instanceGroupManagersRecreateInstancesRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.recreateInstancesInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerCallable() {
    return stub.recreateInstancesInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(size, instanceGroupManager);
   * }
   * </code></pre>
   *
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(
      Integer size, ProjectZoneInstanceGroupManagerName instanceGroupManager) {
    ResizeInstanceGroupManagerHttpRequest request =
        ResizeInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .build();
    return resizeInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(size, instanceGroupManager.toString());
   * }
   * </code></pre>
   *
   * @param size The number of running instances that the managed instance group should maintain at
   *     any given time. The group automatically adds or removes instances to maintain the number of
   *     instances specified by this parameter.
   * @param instanceGroupManager The name of the managed instance group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(Integer size, String instanceGroupManager) {
    ResizeInstanceGroupManagerHttpRequest request =
        ResizeInstanceGroupManagerHttpRequest.newBuilder()
            .setSize(size)
            .setInstanceGroupManager(instanceGroupManager)
            .build();
    return resizeInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeInstanceGroupManagerHttpRequest request = ResizeInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   Operation response = instanceGroupManagerClient.resizeInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation resizeInstanceGroupManager(ResizeInstanceGroupManagerHttpRequest request) {
    return resizeInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Resizes the managed instance group. If you increase the size, the group creates new instances
   * using the current instance template. If you decrease the size, the group deletes instances. The
   * resize operation is marked DONE when the resize actions are scheduled even if the group has not
   * yet added or deleted any instances. You must separately verify the status of the creating or
   * deleting actions with the listmanagedinstances method.
   *
   * <p>When resizing down, the instance group arbitrarily chooses the order in which VMs are
   * deleted. The group takes into account some VM attributes when making the selection including:
   *
   * <p>+ The status of the VM instance. + The health of the VM instance. + The instance template
   * version the VM is based on. + For regional managed instance groups, the location of the VM
   * instance.
   *
   * <p>This list is subject to change.
   *
   * <p>If the group is part of a backend service that has enabled connection draining, it can take
   * up to 60 seconds after the connection draining duration has elapsed before the VM instance is
   * removed or deleted.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   Integer size = 0;
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   ResizeInstanceGroupManagerHttpRequest request = ResizeInstanceGroupManagerHttpRequest.newBuilder()
   *     .setSize(size)
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.resizeInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerCallable() {
    return stub.resizeInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(instanceGroupManager, instanceGroupManagersSetInstanceTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {
    SetInstanceTemplateInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplateInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersSetInstanceTemplateRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetInstanceTemplateRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersSetInstanceTemplateRequest
          instanceGroupManagersSetInstanceTemplateRequestResource) {
    SetInstanceTemplateInstanceGroupManagerHttpRequest request =
        SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetInstanceTemplateRequestResource(
                instanceGroupManagersSetInstanceTemplateRequestResource)
            .build();
    return setInstanceTemplateInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateInstanceGroupManagerHttpRequest request = SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setInstanceTemplateInstanceGroupManager(
      SetInstanceTemplateInstanceGroupManagerHttpRequest request) {
    return setInstanceTemplateInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Specifies the instance template to use when creating new instances in this group. The templates
   * for existing instances in the group do not change unless you recreate them.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetInstanceTemplateRequest instanceGroupManagersSetInstanceTemplateRequestResource = InstanceGroupManagersSetInstanceTemplateRequest.newBuilder().build();
   *   SetInstanceTemplateInstanceGroupManagerHttpRequest request = SetInstanceTemplateInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersSetInstanceTemplateRequestResource(instanceGroupManagersSetInstanceTemplateRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.setInstanceTemplateInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerCallable() {
    return stub.setInstanceTemplateInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(instanceGroupManager, instanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {
    SetTargetPoolsInstanceGroupManagerHttpRequest request =
        SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersSetTargetPoolsRequestResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group.
   * @param instanceGroupManagersSetTargetPoolsRequestResource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersSetTargetPoolsRequest
          instanceGroupManagersSetTargetPoolsRequestResource) {
    SetTargetPoolsInstanceGroupManagerHttpRequest request =
        SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersSetTargetPoolsRequestResource(
                instanceGroupManagersSetTargetPoolsRequestResource)
            .build();
    return setTargetPoolsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsInstanceGroupManagerHttpRequest request = SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.setTargetPoolsInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation setTargetPoolsInstanceGroupManager(
      SetTargetPoolsInstanceGroupManagerHttpRequest request) {
    return setTargetPoolsInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Modifies the target pools to which all instances in this managed instance group are assigned.
   * The target pools automatically apply to all of the instances in the managed instance group.
   * This operation is marked DONE when you make the request even if the instances have not yet been
   * added to their target pools. The change might take some time to apply to all of the instances
   * in the group depending on the size of the group.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersSetTargetPoolsRequest instanceGroupManagersSetTargetPoolsRequestResource = InstanceGroupManagersSetTargetPoolsRequest.newBuilder().build();
   *   SetTargetPoolsInstanceGroupManagerHttpRequest request = SetTargetPoolsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersSetTargetPoolsRequestResource(instanceGroupManagersSetTargetPoolsRequestResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.setTargetPoolsInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerCallable() {
    return stub.setTargetPoolsInstanceGroupManagerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.updatePerInstanceConfigsInstanceGroupManager(instanceGroupManager, instanceGroupManagersUpdatePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersUpdatePerInstanceConfigsReqResource
   *     InstanceGroupManagers.updatePerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updatePerInstanceConfigsInstanceGroupManager(
      ProjectZoneInstanceGroupManagerName instanceGroupManager,
      InstanceGroupManagersUpdatePerInstanceConfigsReq
          instanceGroupManagersUpdatePerInstanceConfigsReqResource) {
    UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest request =
        UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(
                instanceGroupManager == null ? null : instanceGroupManager.toString())
            .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
                instanceGroupManagersUpdatePerInstanceConfigsReqResource)
            .build();
    return updatePerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   ProjectZoneInstanceGroupManagerName instanceGroupManager = ProjectZoneInstanceGroupManagerName.of("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   Operation response = instanceGroupManagerClient.updatePerInstanceConfigsInstanceGroupManager(instanceGroupManager.toString(), instanceGroupManagersUpdatePerInstanceConfigsReqResource);
   * }
   * </code></pre>
   *
   * @param instanceGroupManager The name of the managed instance group. It should conform to
   *     RFC1035.
   * @param instanceGroupManagersUpdatePerInstanceConfigsReqResource
   *     InstanceGroupManagers.updatePerInstanceConfigs
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updatePerInstanceConfigsInstanceGroupManager(
      String instanceGroupManager,
      InstanceGroupManagersUpdatePerInstanceConfigsReq
          instanceGroupManagersUpdatePerInstanceConfigsReqResource) {
    UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest request =
        UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
            .setInstanceGroupManager(instanceGroupManager)
            .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(
                instanceGroupManagersUpdatePerInstanceConfigsReqResource)
            .build();
    return updatePerInstanceConfigsInstanceGroupManager(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest request = UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(instanceGroupManagersUpdatePerInstanceConfigsReqResource)
   *     .build();
   *   Operation response = instanceGroupManagerClient.updatePerInstanceConfigsInstanceGroupManager(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi
  public final Operation updatePerInstanceConfigsInstanceGroupManager(
      UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest request) {
    return updatePerInstanceConfigsInstanceGroupManagerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name
   * serves as a key used to distinguish whether to perform insert or patch.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (InstanceGroupManagerClient instanceGroupManagerClient = InstanceGroupManagerClient.create()) {
   *   String formattedInstanceGroupManager = ProjectZoneInstanceGroupManagerName.format("[PROJECT]", "[ZONE]", "[INSTANCE_GROUP_MANAGER]");
   *   InstanceGroupManagersUpdatePerInstanceConfigsReq instanceGroupManagersUpdatePerInstanceConfigsReqResource = InstanceGroupManagersUpdatePerInstanceConfigsReq.newBuilder().build();
   *   UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest request = UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest.newBuilder()
   *     .setInstanceGroupManager(formattedInstanceGroupManager)
   *     .setInstanceGroupManagersUpdatePerInstanceConfigsReqResource(instanceGroupManagersUpdatePerInstanceConfigsReqResource)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = instanceGroupManagerClient.updatePerInstanceConfigsInstanceGroupManagerCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi
  public final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      updatePerInstanceConfigsInstanceGroupManagerCallable() {
    return stub.updatePerInstanceConfigsInstanceGroupManagerCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class AggregatedListInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage,
          AggregatedListInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<AggregatedListInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      ApiFuture<AggregatedListInstanceGroupManagersPage> futurePage =
          AggregatedListInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              AggregatedListInstanceGroupManagersPage,
              AggregatedListInstanceGroupManagersPagedResponse>() {
            @Override
            public AggregatedListInstanceGroupManagersPagedResponse apply(
                AggregatedListInstanceGroupManagersPage input) {
              return new AggregatedListInstanceGroupManagersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private AggregatedListInstanceGroupManagersPagedResponse(
        AggregatedListInstanceGroupManagersPage page) {
      super(page, AggregatedListInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListInstanceGroupManagersPage
      extends AbstractPage<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage> {

    private AggregatedListInstanceGroupManagersPage(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        InstanceGroupManagerAggregatedList response) {
      super(context, response);
    }

    private static AggregatedListInstanceGroupManagersPage createEmptyPage() {
      return new AggregatedListInstanceGroupManagersPage(null, null);
    }

    @Override
    protected AggregatedListInstanceGroupManagersPage createPage(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        InstanceGroupManagerAggregatedList response) {
      return new AggregatedListInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListInstanceGroupManagersPage> createPageAsync(
        PageContext<
                AggregatedListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerAggregatedList,
                InstanceGroupManagersScopedList>
            context,
        ApiFuture<InstanceGroupManagerAggregatedList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerAggregatedList,
          InstanceGroupManagersScopedList,
          AggregatedListInstanceGroupManagersPage,
          AggregatedListInstanceGroupManagersFixedSizeCollection> {

    private AggregatedListInstanceGroupManagersFixedSizeCollection(
        List<AggregatedListInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new AggregatedListInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListInstanceGroupManagersFixedSizeCollection createCollection(
        List<AggregatedListInstanceGroupManagersPage> pages, int collectionSize) {
      return new AggregatedListInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage,
          ListInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      ApiFuture<ListInstanceGroupManagersPage> futurePage =
          ListInstanceGroupManagersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListInstanceGroupManagersPage, ListInstanceGroupManagersPagedResponse>() {
            @Override
            public ListInstanceGroupManagersPagedResponse apply(
                ListInstanceGroupManagersPage input) {
              return new ListInstanceGroupManagersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListInstanceGroupManagersPagedResponse(ListInstanceGroupManagersPage page) {
      super(page, ListInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstanceGroupManagersPage
      extends AbstractPage<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage> {

    private ListInstanceGroupManagersPage(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      super(context, response);
    }

    private static ListInstanceGroupManagersPage createEmptyPage() {
      return new ListInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListInstanceGroupManagersPage createPage(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        InstanceGroupManagerList response) {
      return new ListInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListInstanceGroupManagersHttpRequest,
                InstanceGroupManagerList,
                InstanceGroupManager>
            context,
        ApiFuture<InstanceGroupManagerList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstanceGroupManagersHttpRequest,
          InstanceGroupManagerList,
          InstanceGroupManager,
          ListInstanceGroupManagersPage,
          ListInstanceGroupManagersFixedSizeCollection> {

    private ListInstanceGroupManagersFixedSizeCollection(
        List<ListInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new ListInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListErrorsInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListErrorsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsInstanceGroupManagersPage,
          ListErrorsInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListErrorsInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListErrorsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
      ApiFuture<ListErrorsInstanceGroupManagersPage> futurePage =
          ListErrorsInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListErrorsInstanceGroupManagersPage, ListErrorsInstanceGroupManagersPagedResponse>() {
            @Override
            public ListErrorsInstanceGroupManagersPagedResponse apply(
                ListErrorsInstanceGroupManagersPage input) {
              return new ListErrorsInstanceGroupManagersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListErrorsInstanceGroupManagersPagedResponse(ListErrorsInstanceGroupManagersPage page) {
      super(page, ListErrorsInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListErrorsInstanceGroupManagersPage
      extends AbstractPage<
          ListErrorsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsInstanceGroupManagersPage> {

    private ListErrorsInstanceGroupManagersPage(
        PageContext<
                ListErrorsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      super(context, response);
    }

    private static ListErrorsInstanceGroupManagersPage createEmptyPage() {
      return new ListErrorsInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListErrorsInstanceGroupManagersPage createPage(
        PageContext<
                ListErrorsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        InstanceGroupManagersListErrorsResponse response) {
      return new ListErrorsInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListErrorsInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListErrorsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListErrorsResponse,
                InstanceManagedByIgmError>
            context,
        ApiFuture<InstanceGroupManagersListErrorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListErrorsInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListErrorsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListErrorsResponse,
          InstanceManagedByIgmError,
          ListErrorsInstanceGroupManagersPage,
          ListErrorsInstanceGroupManagersFixedSizeCollection> {

    private ListErrorsInstanceGroupManagersFixedSizeCollection(
        List<ListErrorsInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListErrorsInstanceGroupManagersFixedSizeCollection createEmptyCollection() {
      return new ListErrorsInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListErrorsInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListErrorsInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListErrorsInstanceGroupManagersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListManagedInstancesInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesInstanceGroupManagersPage,
          ListManagedInstancesInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListManagedInstancesInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
      ApiFuture<ListManagedInstancesInstanceGroupManagersPage> futurePage =
          ListManagedInstancesInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListManagedInstancesInstanceGroupManagersPage,
              ListManagedInstancesInstanceGroupManagersPagedResponse>() {
            @Override
            public ListManagedInstancesInstanceGroupManagersPagedResponse apply(
                ListManagedInstancesInstanceGroupManagersPage input) {
              return new ListManagedInstancesInstanceGroupManagersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListManagedInstancesInstanceGroupManagersPagedResponse(
        ListManagedInstancesInstanceGroupManagersPage page) {
      super(
          page,
          ListManagedInstancesInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagedInstancesInstanceGroupManagersPage
      extends AbstractPage<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesInstanceGroupManagersPage> {

    private ListManagedInstancesInstanceGroupManagersPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      super(context, response);
    }

    private static ListManagedInstancesInstanceGroupManagersPage createEmptyPage() {
      return new ListManagedInstancesInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListManagedInstancesInstanceGroupManagersPage createPage(
        PageContext<
                ListManagedInstancesInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        InstanceGroupManagersListManagedInstancesResponse response) {
      return new ListManagedInstancesInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListManagedInstancesInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListManagedInstancesInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListManagedInstancesResponse,
                ManagedInstance>
            context,
        ApiFuture<InstanceGroupManagersListManagedInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagedInstancesInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse,
          ManagedInstance,
          ListManagedInstancesInstanceGroupManagersPage,
          ListManagedInstancesInstanceGroupManagersFixedSizeCollection> {

    private ListManagedInstancesInstanceGroupManagersFixedSizeCollection(
        List<ListManagedInstancesInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagedInstancesInstanceGroupManagersFixedSizeCollection
        createEmptyCollection() {
      return new ListManagedInstancesInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagedInstancesInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListManagedInstancesInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListManagedInstancesInstanceGroupManagersFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class ListPerInstanceConfigsInstanceGroupManagersPagedResponse
      extends AbstractPagedListResponse<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsInstanceGroupManagersPage,
          ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection> {

    public static ApiFuture<ListPerInstanceConfigsInstanceGroupManagersPagedResponse> createAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
      ApiFuture<ListPerInstanceConfigsInstanceGroupManagersPage> futurePage =
          ListPerInstanceConfigsInstanceGroupManagersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<
              ListPerInstanceConfigsInstanceGroupManagersPage,
              ListPerInstanceConfigsInstanceGroupManagersPagedResponse>() {
            @Override
            public ListPerInstanceConfigsInstanceGroupManagersPagedResponse apply(
                ListPerInstanceConfigsInstanceGroupManagersPage input) {
              return new ListPerInstanceConfigsInstanceGroupManagersPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPerInstanceConfigsInstanceGroupManagersPagedResponse(
        ListPerInstanceConfigsInstanceGroupManagersPage page) {
      super(
          page,
          ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPerInstanceConfigsInstanceGroupManagersPage
      extends AbstractPage<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsInstanceGroupManagersPage> {

    private ListPerInstanceConfigsInstanceGroupManagersPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      super(context, response);
    }

    private static ListPerInstanceConfigsInstanceGroupManagersPage createEmptyPage() {
      return new ListPerInstanceConfigsInstanceGroupManagersPage(null, null);
    }

    @Override
    protected ListPerInstanceConfigsInstanceGroupManagersPage createPage(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        InstanceGroupManagersListPerInstanceConfigsResp response) {
      return new ListPerInstanceConfigsInstanceGroupManagersPage(context, response);
    }

    @Override
    public ApiFuture<ListPerInstanceConfigsInstanceGroupManagersPage> createPageAsync(
        PageContext<
                ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                InstanceGroupManagersListPerInstanceConfigsResp,
                PerInstanceConfig>
            context,
        ApiFuture<InstanceGroupManagersListPerInstanceConfigsResp> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp,
          PerInstanceConfig,
          ListPerInstanceConfigsInstanceGroupManagersPage,
          ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection> {

    private ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection(
        List<ListPerInstanceConfigsInstanceGroupManagersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection
        createEmptyCollection() {
      return new ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection createCollection(
        List<ListPerInstanceConfigsInstanceGroupManagersPage> pages, int collectionSize) {
      return new ListPerInstanceConfigsInstanceGroupManagersFixedSizeCollection(
          pages, collectionSize);
    }
  }
}
