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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstanceGroupManagerClient.AggregatedListInstanceGroupManagersPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagerClient.ListErrorsInstanceGroupManagersPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagerClient.ListInstanceGroupManagersPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagerClient.ListManagedInstancesInstanceGroupManagersPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagerClient.ListPerInstanceConfigsInstanceGroupManagersPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.AbandonInstancesInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupManagersHttpRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.CreateInstancesInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.DeleteInstancesInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupManagerList;
import com.google.cloud.compute.v1.InstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListManagedInstancesResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListPerInstanceConfigsResp;
import com.google.cloud.compute.v1.ListErrorsInstanceGroupManagersHttpRequest;
import com.google.cloud.compute.v1.ListInstanceGroupManagersHttpRequest;
import com.google.cloud.compute.v1.ListManagedInstancesInstanceGroupManagersHttpRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsInstanceGroupManagersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneInstanceGroupManagerName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.RecreateInstancesInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.ResizeInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.SetTargetPoolsInstanceGroupManagerHttpRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonInstanceGroupManagerStub extends InstanceGroupManagerStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.abandonInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AbandonInstancesInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/abandonInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
      aggregatedListInstanceGroupManagersMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListInstanceGroupManagersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/instanceGroupManagers"))
                      .setQueryParams(
                          Sets.<String>newHashSet(
                              "filter", "includeAllScopes", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupManagerAggregatedList>newBuilder()
                      .setResponseInstance(InstanceGroupManagerAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>
      applyUpdatesToInstancesInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.applyUpdatesToInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CreateInstancesInstanceGroupManagerHttpRequest, Operation>
      createInstancesInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<CreateInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.createInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<CreateInstancesInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/createInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.deleteInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteInstancesInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deleteInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      deletePerInstanceConfigsInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.deletePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupManager>newBuilder()
                      .setResponseInstance(InstanceGroupManager.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/instanceGroupManagers"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
      listInstanceGroupManagersMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListInstanceGroupManagersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/instanceGroupManagers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupManagerList>newBuilder()
                      .setResponseInstance(InstanceGroupManagerList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsInstanceGroupManagersMethodDescriptor =
          ApiMethodDescriptor
              .<ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
                  newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.listErrors")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListErrorsInstanceGroupManagersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listErrors"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupManagersListErrorsResponse>newBuilder()
                      .setResponseInstance(
                          InstanceGroupManagersListErrorsResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersMethodDescriptor =
          ApiMethodDescriptor
              .<ListManagedInstancesInstanceGroupManagersHttpRequest,
                  InstanceGroupManagersListManagedInstancesResponse>
                  newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.listManagedInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListManagedInstancesInstanceGroupManagersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser
                      .<InstanceGroupManagersListManagedInstancesResponse>newBuilder()
                      .setResponseInstance(
                          InstanceGroupManagersListManagedInstancesResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsInstanceGroupManagersMethodDescriptor =
          ApiMethodDescriptor
              .<ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                  InstanceGroupManagersListPerInstanceConfigsResp>
                  newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.listPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListPerInstanceConfigsInstanceGroupManagersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser
                      .<InstanceGroupManagersListPerInstanceConfigsResp>newBuilder()
                      .setResponseInstance(
                          InstanceGroupManagersListPerInstanceConfigsResp.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<PatchInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      patchPerInstanceConfigsInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.patchPerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.recreateInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<RecreateInstancesInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/recreateInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<ResizeInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ResizeInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resize"))
                      .setQueryParams(Sets.<String>newHashSet("requestId", "size"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.setInstanceTemplate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetInstanceTemplateInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor.<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.setTargetPools")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetTargetPoolsInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setTargetPools"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      updatePerInstanceConfigsInstanceGroupManagerMethodDescriptor =
          ApiMethodDescriptor
              .<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroupManagers.updatePerInstanceConfigs")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupManagerName.newFactory())
                      .setResourceNameField("instanceGroupManager")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
      aggregatedListInstanceGroupManagersCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest,
          AggregatedListInstanceGroupManagersPagedResponse>
      aggregatedListInstanceGroupManagersPagedCallable;
  private final UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>
      applyUpdatesToInstancesInstanceGroupManagerCallable;
  private final UnaryCallable<CreateInstancesInstanceGroupManagerHttpRequest, Operation>
      createInstancesInstanceGroupManagerCallable;
  private final UnaryCallable<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerCallable;
  private final UnaryCallable<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerCallable;
  private final UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      deletePerInstanceConfigsInstanceGroupManagerCallable;
  private final UnaryCallable<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerCallable;
  private final UnaryCallable<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerCallable;
  private final UnaryCallable<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
      listInstanceGroupManagersCallable;
  private final UnaryCallable<
          ListInstanceGroupManagersHttpRequest, ListInstanceGroupManagersPagedResponse>
      listInstanceGroupManagersPagedCallable;
  private final UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsInstanceGroupManagersCallable;
  private final UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, ListErrorsInstanceGroupManagersPagedResponse>
      listErrorsInstanceGroupManagersPagedCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersCallable;
  private final UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          ListManagedInstancesInstanceGroupManagersPagedResponse>
      listManagedInstancesInstanceGroupManagersPagedCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsInstanceGroupManagersCallable;
  private final UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          ListPerInstanceConfigsInstanceGroupManagersPagedResponse>
      listPerInstanceConfigsInstanceGroupManagersPagedCallable;
  private final UnaryCallable<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerCallable;
  private final UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      patchPerInstanceConfigsInstanceGroupManagerCallable;
  private final UnaryCallable<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerCallable;
  private final UnaryCallable<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerCallable;
  private final UnaryCallable<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerCallable;
  private final UnaryCallable<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerCallable;
  private final UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      updatePerInstanceConfigsInstanceGroupManagerCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupManagerStub create(
      InstanceGroupManagerStubSettings settings) throws IOException {
    return new HttpJsonInstanceGroupManagerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupManagerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupManagerStub(
        InstanceGroupManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupManagerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupManagerStub(
        InstanceGroupManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagerStub(
      InstanceGroupManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupManagerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupManagerStub(
      InstanceGroupManagerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
        abandonInstancesInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(abandonInstancesInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
        aggregatedListInstanceGroupManagersTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupManagersHttpRequest,
                    InstanceGroupManagerAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListInstanceGroupManagersMethodDescriptor)
                .build();
    HttpJsonCallSettings<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>
        applyUpdatesToInstancesInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(applyUpdatesToInstancesInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateInstancesInstanceGroupManagerHttpRequest, Operation>
        createInstancesInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<CreateInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(createInstancesInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupManagerHttpRequest, Operation>
        deleteInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings.<DeleteInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
        deleteInstancesInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstancesInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
        deletePerInstanceConfigsInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePerInstanceConfigsInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
        getInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>newBuilder()
                .setMethodDescriptor(getInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceGroupManagerHttpRequest, Operation>
        insertInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings.<InsertInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
        listInstanceGroupManagersTransportSettings =
            HttpJsonCallSettings
                .<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>newBuilder()
                .setMethodDescriptor(listInstanceGroupManagersMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
        listErrorsInstanceGroupManagersTransportSettings =
            HttpJsonCallSettings
                .<ListErrorsInstanceGroupManagersHttpRequest,
                    InstanceGroupManagersListErrorsResponse>
                    newBuilder()
                .setMethodDescriptor(listErrorsInstanceGroupManagersMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListManagedInstancesInstanceGroupManagersHttpRequest,
            InstanceGroupManagersListManagedInstancesResponse>
        listManagedInstancesInstanceGroupManagersTransportSettings =
            HttpJsonCallSettings
                .<ListManagedInstancesInstanceGroupManagersHttpRequest,
                    InstanceGroupManagersListManagedInstancesResponse>
                    newBuilder()
                .setMethodDescriptor(listManagedInstancesInstanceGroupManagersMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
            InstanceGroupManagersListPerInstanceConfigsResp>
        listPerInstanceConfigsInstanceGroupManagersTransportSettings =
            HttpJsonCallSettings
                .<ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
                    InstanceGroupManagersListPerInstanceConfigsResp>
                    newBuilder()
                .setMethodDescriptor(listPerInstanceConfigsInstanceGroupManagersMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchInstanceGroupManagerHttpRequest, Operation>
        patchInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings.<PatchInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
        patchPerInstanceConfigsInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPerInstanceConfigsInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
        recreateInstancesInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(recreateInstancesInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeInstanceGroupManagerHttpRequest, Operation>
        resizeInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings.<ResizeInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(resizeInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
        setInstanceTemplateInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setInstanceTemplateInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
        setTargetPoolsInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setTargetPoolsInstanceGroupManagerMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
        updatePerInstanceConfigsInstanceGroupManagerTransportSettings =
            HttpJsonCallSettings
                .<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updatePerInstanceConfigsInstanceGroupManagerMethodDescriptor)
                .build();

    this.abandonInstancesInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            abandonInstancesInstanceGroupManagerTransportSettings,
            settings.abandonInstancesInstanceGroupManagerSettings(),
            clientContext);
    this.aggregatedListInstanceGroupManagersCallable =
        callableFactory.createUnaryCallable(
            aggregatedListInstanceGroupManagersTransportSettings,
            settings.aggregatedListInstanceGroupManagersSettings(),
            clientContext);
    this.aggregatedListInstanceGroupManagersPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListInstanceGroupManagersTransportSettings,
            settings.aggregatedListInstanceGroupManagersSettings(),
            clientContext);
    this.applyUpdatesToInstancesInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            applyUpdatesToInstancesInstanceGroupManagerTransportSettings,
            settings.applyUpdatesToInstancesInstanceGroupManagerSettings(),
            clientContext);
    this.createInstancesInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            createInstancesInstanceGroupManagerTransportSettings,
            settings.createInstancesInstanceGroupManagerSettings(),
            clientContext);
    this.deleteInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceGroupManagerTransportSettings,
            settings.deleteInstanceGroupManagerSettings(),
            clientContext);
    this.deleteInstancesInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            deleteInstancesInstanceGroupManagerTransportSettings,
            settings.deleteInstancesInstanceGroupManagerSettings(),
            clientContext);
    this.deletePerInstanceConfigsInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            deletePerInstanceConfigsInstanceGroupManagerTransportSettings,
            settings.deletePerInstanceConfigsInstanceGroupManagerSettings(),
            clientContext);
    this.getInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            getInstanceGroupManagerTransportSettings,
            settings.getInstanceGroupManagerSettings(),
            clientContext);
    this.insertInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            insertInstanceGroupManagerTransportSettings,
            settings.insertInstanceGroupManagerSettings(),
            clientContext);
    this.listInstanceGroupManagersCallable =
        callableFactory.createUnaryCallable(
            listInstanceGroupManagersTransportSettings,
            settings.listInstanceGroupManagersSettings(),
            clientContext);
    this.listInstanceGroupManagersPagedCallable =
        callableFactory.createPagedCallable(
            listInstanceGroupManagersTransportSettings,
            settings.listInstanceGroupManagersSettings(),
            clientContext);
    this.listErrorsInstanceGroupManagersCallable =
        callableFactory.createUnaryCallable(
            listErrorsInstanceGroupManagersTransportSettings,
            settings.listErrorsInstanceGroupManagersSettings(),
            clientContext);
    this.listErrorsInstanceGroupManagersPagedCallable =
        callableFactory.createPagedCallable(
            listErrorsInstanceGroupManagersTransportSettings,
            settings.listErrorsInstanceGroupManagersSettings(),
            clientContext);
    this.listManagedInstancesInstanceGroupManagersCallable =
        callableFactory.createUnaryCallable(
            listManagedInstancesInstanceGroupManagersTransportSettings,
            settings.listManagedInstancesInstanceGroupManagersSettings(),
            clientContext);
    this.listManagedInstancesInstanceGroupManagersPagedCallable =
        callableFactory.createPagedCallable(
            listManagedInstancesInstanceGroupManagersTransportSettings,
            settings.listManagedInstancesInstanceGroupManagersSettings(),
            clientContext);
    this.listPerInstanceConfigsInstanceGroupManagersCallable =
        callableFactory.createUnaryCallable(
            listPerInstanceConfigsInstanceGroupManagersTransportSettings,
            settings.listPerInstanceConfigsInstanceGroupManagersSettings(),
            clientContext);
    this.listPerInstanceConfigsInstanceGroupManagersPagedCallable =
        callableFactory.createPagedCallable(
            listPerInstanceConfigsInstanceGroupManagersTransportSettings,
            settings.listPerInstanceConfigsInstanceGroupManagersSettings(),
            clientContext);
    this.patchInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            patchInstanceGroupManagerTransportSettings,
            settings.patchInstanceGroupManagerSettings(),
            clientContext);
    this.patchPerInstanceConfigsInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            patchPerInstanceConfigsInstanceGroupManagerTransportSettings,
            settings.patchPerInstanceConfigsInstanceGroupManagerSettings(),
            clientContext);
    this.recreateInstancesInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            recreateInstancesInstanceGroupManagerTransportSettings,
            settings.recreateInstancesInstanceGroupManagerSettings(),
            clientContext);
    this.resizeInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            resizeInstanceGroupManagerTransportSettings,
            settings.resizeInstanceGroupManagerSettings(),
            clientContext);
    this.setInstanceTemplateInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            setInstanceTemplateInstanceGroupManagerTransportSettings,
            settings.setInstanceTemplateInstanceGroupManagerSettings(),
            clientContext);
    this.setTargetPoolsInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            setTargetPoolsInstanceGroupManagerTransportSettings,
            settings.setTargetPoolsInstanceGroupManagerSettings(),
            clientContext);
    this.updatePerInstanceConfigsInstanceGroupManagerCallable =
        callableFactory.createUnaryCallable(
            updatePerInstanceConfigsInstanceGroupManagerTransportSettings,
            settings.updatePerInstanceConfigsInstanceGroupManagerSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AbandonInstancesInstanceGroupManagerHttpRequest, Operation>
      abandonInstancesInstanceGroupManagerCallable() {
    return abandonInstancesInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest,
          AggregatedListInstanceGroupManagersPagedResponse>
      aggregatedListInstanceGroupManagersPagedCallable() {
    return aggregatedListInstanceGroupManagersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInstanceGroupManagersHttpRequest, InstanceGroupManagerAggregatedList>
      aggregatedListInstanceGroupManagersCallable() {
    return aggregatedListInstanceGroupManagersCallable;
  }

  @BetaApi
  public UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerHttpRequest, Operation>
      applyUpdatesToInstancesInstanceGroupManagerCallable() {
    return applyUpdatesToInstancesInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<CreateInstancesInstanceGroupManagerHttpRequest, Operation>
      createInstancesInstanceGroupManagerCallable() {
    return createInstancesInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteInstanceGroupManagerHttpRequest, Operation>
      deleteInstanceGroupManagerCallable() {
    return deleteInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteInstancesInstanceGroupManagerHttpRequest, Operation>
      deleteInstancesInstanceGroupManagerCallable() {
    return deleteInstancesInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      deletePerInstanceConfigsInstanceGroupManagerCallable() {
    return deletePerInstanceConfigsInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<GetInstanceGroupManagerHttpRequest, InstanceGroupManager>
      getInstanceGroupManagerCallable() {
    return getInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<InsertInstanceGroupManagerHttpRequest, Operation>
      insertInstanceGroupManagerCallable() {
    return insertInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupManagersHttpRequest, ListInstanceGroupManagersPagedResponse>
      listInstanceGroupManagersPagedCallable() {
    return listInstanceGroupManagersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupManagersHttpRequest, InstanceGroupManagerList>
      listInstanceGroupManagersCallable() {
    return listInstanceGroupManagersCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, ListErrorsInstanceGroupManagersPagedResponse>
      listErrorsInstanceGroupManagersPagedCallable() {
    return listErrorsInstanceGroupManagersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListErrorsInstanceGroupManagersHttpRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsInstanceGroupManagersCallable() {
    return listErrorsInstanceGroupManagersCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          ListManagedInstancesInstanceGroupManagersPagedResponse>
      listManagedInstancesInstanceGroupManagersPagedCallable() {
    return listManagedInstancesInstanceGroupManagersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesInstanceGroupManagersCallable() {
    return listManagedInstancesInstanceGroupManagersCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          ListPerInstanceConfigsInstanceGroupManagersPagedResponse>
      listPerInstanceConfigsInstanceGroupManagersPagedCallable() {
    return listPerInstanceConfigsInstanceGroupManagersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersHttpRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsInstanceGroupManagersCallable() {
    return listPerInstanceConfigsInstanceGroupManagersCallable;
  }

  @BetaApi
  public UnaryCallable<PatchInstanceGroupManagerHttpRequest, Operation>
      patchInstanceGroupManagerCallable() {
    return patchInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      patchPerInstanceConfigsInstanceGroupManagerCallable() {
    return patchPerInstanceConfigsInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<RecreateInstancesInstanceGroupManagerHttpRequest, Operation>
      recreateInstancesInstanceGroupManagerCallable() {
    return recreateInstancesInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<ResizeInstanceGroupManagerHttpRequest, Operation>
      resizeInstanceGroupManagerCallable() {
    return resizeInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<SetInstanceTemplateInstanceGroupManagerHttpRequest, Operation>
      setInstanceTemplateInstanceGroupManagerCallable() {
    return setInstanceTemplateInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<SetTargetPoolsInstanceGroupManagerHttpRequest, Operation>
      setTargetPoolsInstanceGroupManagerCallable() {
    return setTargetPoolsInstanceGroupManagerCallable;
  }

  @BetaApi
  public UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerHttpRequest, Operation>
      updatePerInstanceConfigsInstanceGroupManagerCallable() {
    return updatePerInstanceConfigsInstanceGroupManagerCallable;
  }

  @Override
  public final void close() {
    shutdown();
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
