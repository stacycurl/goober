package goober.free

import scala.language.higherKinds

import cats.free.Free
import goober.free.accessanalyzer.AccessAnalyzerIO
import goober.free.acm.AcmIO
import goober.free.acmpca.AcmPcaIO
import goober.free.alexaforbusiness.AlexaForBusinessIO
import goober.free.amp.AmpIO
import goober.free.amplify.AmplifyIO
import goober.free.amplifybackend.AmplifyBackendIO
import goober.free.apigateway.ApiGatewayIO
import goober.free.apigatewaymanagementapi.ApiGatewayManagementApiIO
import goober.free.apigatewayv2.ApiGatewayV2IO
import goober.free.appconfig.AppConfigIO
import goober.free.appflow.AppflowIO
import goober.free.appintegrations.AppIntegrationsIO
import goober.free.applicationautoscaling.ApplicationAutoScalingIO
import goober.free.applicationcostprofiler.ApplicationCostProfilerIO
import goober.free.applicationdiscovery.ApplicationDiscoveryIO
import goober.free.applicationinsights.ApplicationInsightsIO
import goober.free.appmesh.AppMeshIO
import goober.free.apprunner.AppRunnerIO
import goober.free.appstream.AppStreamIO
import goober.free.appsync.AppSyncIO
import goober.free.athena.AthenaIO
import goober.free.auditmanager.AuditManagerIO
import goober.free.autoscaling.AutoScalingIO
import goober.free.autoscalingplans.AutoScalingPlansIO
import goober.free.backup.BackupIO
import goober.free.batch.BatchIO
import goober.free.braket.BraketIO
import goober.free.budgets.BudgetsIO
import goober.free.chime.ChimeIO
import goober.free.cloud9.Cloud9IO
import goober.free.clouddirectory.CloudDirectoryIO
import goober.free.cloudformation.CloudFormationIO
import goober.free.cloudfront.CloudFrontIO
import goober.free.cloudhsm.CloudHsmIO
import goober.free.cloudhsmv2.CloudHsmV2IO
import goober.free.cloudsearch.CloudSearchIO
import goober.free.cloudsearchdomain.CloudSearchDomainIO
import goober.free.cloudtrail.CloudTrailIO
import goober.free.cloudwatch.CloudWatchIO
import goober.free.cloudwatchevents.CloudWatchEventsIO
import goober.free.cloudwatchlogs.CloudWatchLogsIO
import goober.free.codeartifact.CodeartifactIO
import goober.free.codebuild.CodeBuildIO
import goober.free.codecommit.CodeCommitIO
import goober.free.codedeploy.CodeDeployIO
import goober.free.codeguruprofiler.CodeGuruProfilerIO
import goober.free.codegurureviewer.CodeGuruReviewerIO
import goober.free.codepipeline.CodePipelineIO
import goober.free.codestar.CodeStarIO
import goober.free.codestarconnections.CodeStarConnectionsIO
import goober.free.codestarnotifications.CodestarNotificationsIO
import goober.free.cognitoidentity.CognitoIdentityIO
import goober.free.cognitoidentityprovider.CognitoIdentityProviderIO
import goober.free.cognitosync.CognitoSyncIO
import goober.free.comprehend.ComprehendIO
import goober.free.comprehendmedical.ComprehendMedicalIO
import goober.free.computeoptimizer.ComputeOptimizerIO
import goober.free.config.ConfigIO
import goober.free.connect.ConnectIO
import goober.free.connectcontactlens.ConnectContactLensIO
import goober.free.connectparticipant.ConnectParticipantIO
import goober.free.costandusagereport.CostAndUsageReportIO
import goober.free.costexplorer.CostExplorerIO
import goober.free.customerprofiles.CustomerProfilesIO
import goober.free.databasemigration.DatabaseMigrationIO
import goober.free.databrew.DataBrewIO
import goober.free.dataexchange.DataExchangeIO
import goober.free.datapipeline.DataPipelineIO
import goober.free.datasync.DataSyncIO
import goober.free.dax.DaxIO
import goober.free.detective.DetectiveIO
import goober.free.devicefarm.DeviceFarmIO
import goober.free.devopsguru.DevOpsGuruIO
import goober.free.directconnect.DirectConnectIO
import goober.free.directory.DirectoryIO
import goober.free.dlm.DlmIO
import goober.free.docdb.DocDbIO
import goober.free.dynamodb.DynamoDbIO
import goober.free.dynamodbstreams.DynamoDbStreamsIO
import goober.free.ebs.EbsIO
import goober.free.ec2.Ec2IO
import goober.free.ec2instanceconnect.Ec2InstanceConnectIO
import goober.free.ecr.EcrIO
import goober.free.ecrpublic.EcrPublicIO
import goober.free.ecs.EcsIO
import goober.free.efs.EfsIO
import goober.free.eks.EksIO
import goober.free.elasticache.ElastiCacheIO
import goober.free.elasticbeanstalk.ElasticBeanstalkIO
import goober.free.elasticinference.ElasticInferenceIO
import goober.free.elasticloadbalancing.ElasticLoadBalancingIO
import goober.free.elasticloadbalancingv2.ElasticLoadBalancingV2IO
import goober.free.elasticsearch.ElasticsearchIO
import goober.free.elastictranscoder.ElasticTranscoderIO
import goober.free.emr.EmrIO
import goober.free.emrcontainers.EmrContainersIO
import goober.free.eventbridge.EventBridgeIO
import goober.free.finspace.FinspaceIO
import goober.free.finspacedata.FinspaceDataIO
import goober.free.firehose.FirehoseIO
import goober.free.fis.FisIO
import goober.free.fms.FmsIO
import goober.free.forecast.ForecastIO
import goober.free.forecastquery.ForecastqueryIO
import goober.free.frauddetector.FraudDetectorIO
import goober.free.fsx.FSxIO
import goober.free.gamelift.GameLiftIO
import goober.free.glacier.GlacierIO
import goober.free.globalaccelerator.GlobalAcceleratorIO
import goober.free.glue.GlueIO
import goober.free.greengrass.GreengrassIO
import goober.free.greengrassv2.GreengrassV2IO
import goober.free.groundstation.GroundStationIO
import goober.free.guardduty.GuardDutyIO
import goober.free.health.HealthIO
import goober.free.healthlake.HealthLakeIO
import goober.free.honeycode.HoneycodeIO
import goober.free.iam.IamIO
import goober.free.identitystore.IdentitystoreIO
import goober.free.imagebuilder.ImagebuilderIO
import goober.free.inspector.InspectorIO
import goober.free.iot.IotIO
import goober.free.iot1clickdevices.Iot1ClickDevicesIO
import goober.free.iot1clickprojects.Iot1ClickProjectsIO
import goober.free.iotanalytics.IoTAnalyticsIO
import goober.free.iotdataplane.IotDataPlaneIO
import goober.free.iotdeviceadvisor.IotDeviceAdvisorIO
import goober.free.iotevents.IotEventsIO
import goober.free.ioteventsdata.IotEventsDataIO
import goober.free.iotfleethub.IoTFleetHubIO
import goober.free.iotjobsdataplane.IotJobsDataPlaneIO
import goober.free.iotsecuretunneling.IoTSecureTunnelingIO
import goober.free.iotsitewise.IoTSiteWiseIO
import goober.free.iotthingsgraph.IoTThingsGraphIO
import goober.free.iotwireless.IotWirelessIO
import goober.free.ivs.IvsIO
import goober.free.kafka.KafkaIO
import goober.free.kendra.KendraIO
import goober.free.kinesis.KinesisIO
import goober.free.kinesisanalytics.KinesisAnalyticsIO
import goober.free.kinesisanalyticsv2.KinesisAnalyticsV2IO
import goober.free.kinesisvideo.KinesisVideoIO
import goober.free.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaIO
import goober.free.kinesisvideomedia.KinesisVideoMediaIO
import goober.free.kinesisvideosignaling.KinesisVideoSignalingIO
import goober.free.kms.KmsIO
import goober.free.lakeformation.LakeFormationIO
import goober.free.lambda.LambdaIO
import goober.free.lexmodelbuilding.LexModelBuildingIO
import goober.free.lexmodelsv2.LexModelsV2IO
import goober.free.lexruntime.LexRuntimeIO
import goober.free.lexruntimev2.LexRuntimeV2IO
import goober.free.licensemanager.LicenseManagerIO
import goober.free.lightsail.LightsailIO
import goober.free.location.LocationIO
import goober.free.lookoutequipment.LookoutEquipmentIO
import goober.free.lookoutmetrics.LookoutMetricsIO
import goober.free.lookoutvision.LookoutVisionIO
import goober.free.machinelearning.MachineLearningIO
import goober.free.macie.MacieIO
import goober.free.macie2.Macie2IO
import goober.free.managedblockchain.ManagedBlockchainIO
import goober.free.marketplacecatalog.MarketplaceCatalogIO
import goober.free.marketplacecommerceanalytics.MarketplaceCommerceAnalyticsIO
import goober.free.marketplaceentitlement.MarketplaceEntitlementIO
import goober.free.marketplacemetering.MarketplaceMeteringIO
import goober.free.mediaconnect.MediaConnectIO
import goober.free.mediaconvert.MediaConvertIO
import goober.free.medialive.MediaLiveIO
import goober.free.mediapackage.MediaPackageIO
import goober.free.mediapackagevod.MediaPackageVodIO
import goober.free.mediastore.MediaStoreIO
import goober.free.mediastoredata.MediaStoreDataIO
import goober.free.mediatailor.MediaTailorIO
import goober.free.mgn.MgnIO
import goober.free.migrationhub.MigrationHubIO
import goober.free.migrationhubconfig.MigrationHubConfigIO
import goober.free.mobile.MobileIO
import goober.free.mq.MqIO
import goober.free.mturk.MTurkIO
import goober.free.mwaa.MwaaIO
import goober.free.neptune.NeptuneIO
import goober.free.networkfirewall.NetworkFirewallIO
import goober.free.networkmanager.NetworkManagerIO
import goober.free.nimble.NimbleIO
import goober.free.opsworks.OpsWorksIO
import goober.free.opsworkscm.OpsWorksCmIO
import goober.free.organizations.OrganizationsIO
import goober.free.outposts.OutpostsIO
import goober.free.personalize.PersonalizeIO
import goober.free.personalizeevents.PersonalizeEventsIO
import goober.free.personalizeruntime.PersonalizeRuntimeIO
import goober.free.pi.PiIO
import goober.free.pinpoint.PinpointIO
import goober.free.pinpointemail.PinpointEmailIO
import goober.free.pinpointsmsvoice.PinpointSmsVoiceIO
import goober.free.polly.PollyIO
import goober.free.pricing.PricingIO
import goober.free.proton.ProtonIO
import goober.free.qldb.QldbIO
import goober.free.qldbsession.QldbSessionIO
import goober.free.quicksight.QuickSightIO
import goober.free.ram.RamIO
import goober.free.rds.RdsIO
import goober.free.rdsdata.RdsDataIO
import goober.free.redshift.RedshiftIO
import goober.free.redshiftdata.RedshiftDataIO
import goober.free.rekognition.RekognitionIO
import goober.free.resourcegroups.ResourceGroupsIO
import goober.free.resourcegroupstaggingapi.ResourceGroupsTaggingApiIO
import goober.free.robomaker.RoboMakerIO
import goober.free.route53.Route53IO
import goober.free.route53domains.Route53DomainsIO
import goober.free.route53resolver.Route53ResolverIO
import goober.free.s3.S3IO
import goober.free.s3control.S3ControlIO
import goober.free.s3outposts.S3OutpostsIO
import goober.free.sagemaker.SageMakerIO
import goober.free.sagemakera2iruntime.SageMakerA2IRuntimeIO
import goober.free.sagemakeredge.SagemakerEdgeIO
import goober.free.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeIO
import goober.free.sagemakerruntime.SageMakerRuntimeIO
import goober.free.savingsplans.SavingsplansIO
import goober.free.schemas.SchemasIO
import goober.free.secretsmanager.SecretsManagerIO
import goober.free.securityhub.SecurityHubIO
import goober.free.serverlessapplicationrepository.ServerlessApplicationRepositoryIO
import goober.free.servicecatalog.ServiceCatalogIO
import goober.free.servicecatalogappregistry.ServiceCatalogAppRegistryIO
import goober.free.servicediscovery.ServiceDiscoveryIO
import goober.free.servicequotas.ServiceQuotasIO
import goober.free.ses.SesIO
import goober.free.sesv2.SesV2IO
import goober.free.sfn.SfnIO
import goober.free.shield.ShieldIO
import goober.free.signer.SignerIO
import goober.free.sms.SmsIO
import goober.free.snowball.SnowballIO
import goober.free.sns.SnsIO
import goober.free.sqs.SqsIO
import goober.free.ssm.SsmIO
import goober.free.ssmcontacts.SsmContactsIO
import goober.free.ssmincidents.SsmIncidentsIO
import goober.free.sso.SsoIO
import goober.free.ssoadmin.SsoAdminIO
import goober.free.ssooidc.SsoOidcIO
import goober.free.storagegateway.StorageGatewayIO
import goober.free.sts.StsIO
import goober.free.support.SupportIO
import goober.free.swf.SwfIO
import goober.free.synthetics.SyntheticsIO
import goober.free.textract.TextractIO
import goober.free.timestreamquery.TimestreamQueryIO
import goober.free.timestreamwrite.TimestreamWriteIO
import goober.free.transcribe.TranscribeIO
import goober.free.transfer.TransferIO
import goober.free.translate.TranslateIO
import goober.free.waf.WafIO
import goober.free.wafregional.WafRegionalIO
import goober.free.wafv2.Wafv2IO
import goober.free.wellarchitected.WellArchitectedIO
import goober.free.workdocs.WorkDocsIO
import goober.free.worklink.WorkLinkIO
import goober.free.workmail.WorkMailIO
import goober.free.workmailmessageflow.WorkMailMessageFlowIO
import goober.free.workspaces.WorkSpacesIO
import goober.free.xray.XRayIO
import software.amazon.awssdk.services.accessanalyzer.AccessAnalyzerClient
import software.amazon.awssdk.services.acm.AcmClient
import software.amazon.awssdk.services.acmpca.AcmPcaClient
import software.amazon.awssdk.services.alexaforbusiness.AlexaForBusinessClient
import software.amazon.awssdk.services.amp.AmpClient
import software.amazon.awssdk.services.amplify.AmplifyClient
import software.amazon.awssdk.services.amplifybackend.AmplifyBackendClient
import software.amazon.awssdk.services.apigateway.ApiGatewayClient
import software.amazon.awssdk.services.apigatewaymanagementapi.ApiGatewayManagementApiClient
import software.amazon.awssdk.services.apigatewayv2.ApiGatewayV2Client
import software.amazon.awssdk.services.appconfig.AppConfigClient
import software.amazon.awssdk.services.appflow.AppflowClient
import software.amazon.awssdk.services.appintegrations.AppIntegrationsClient
import software.amazon.awssdk.services.applicationautoscaling.ApplicationAutoScalingClient
import software.amazon.awssdk.services.applicationcostprofiler.ApplicationCostProfilerClient
import software.amazon.awssdk.services.applicationdiscovery.ApplicationDiscoveryClient
import software.amazon.awssdk.services.applicationinsights.ApplicationInsightsClient
import software.amazon.awssdk.services.appmesh.AppMeshClient
import software.amazon.awssdk.services.apprunner.AppRunnerClient
import software.amazon.awssdk.services.appstream.AppStreamClient
import software.amazon.awssdk.services.appsync.AppSyncClient
import software.amazon.awssdk.services.athena.AthenaClient
import software.amazon.awssdk.services.auditmanager.AuditManagerClient
import software.amazon.awssdk.services.autoscaling.AutoScalingClient
import software.amazon.awssdk.services.autoscalingplans.AutoScalingPlansClient
import software.amazon.awssdk.services.backup.BackupClient
import software.amazon.awssdk.services.batch.BatchClient
import software.amazon.awssdk.services.braket.BraketClient
import software.amazon.awssdk.services.budgets.BudgetsClient
import software.amazon.awssdk.services.chime.ChimeClient
import software.amazon.awssdk.services.cloud9.Cloud9Client
import software.amazon.awssdk.services.clouddirectory.CloudDirectoryClient
import software.amazon.awssdk.services.cloudformation.CloudFormationClient
import software.amazon.awssdk.services.cloudfront.CloudFrontClient
import software.amazon.awssdk.services.cloudhsm.CloudHsmClient
import software.amazon.awssdk.services.cloudhsmv2.CloudHsmV2Client
import software.amazon.awssdk.services.cloudsearch.CloudSearchClient
import software.amazon.awssdk.services.cloudsearchdomain.CloudSearchDomainClient
import software.amazon.awssdk.services.cloudtrail.CloudTrailClient
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient
import software.amazon.awssdk.services.cloudwatchevents.CloudWatchEventsClient
import software.amazon.awssdk.services.cloudwatchlogs.CloudWatchLogsClient
import software.amazon.awssdk.services.codeartifact.CodeartifactClient
import software.amazon.awssdk.services.codebuild.CodeBuildClient
import software.amazon.awssdk.services.codecommit.CodeCommitClient
import software.amazon.awssdk.services.codedeploy.CodeDeployClient
import software.amazon.awssdk.services.codeguruprofiler.CodeGuruProfilerClient
import software.amazon.awssdk.services.codegurureviewer.CodeGuruReviewerClient
import software.amazon.awssdk.services.codepipeline.CodePipelineClient
import software.amazon.awssdk.services.codestar.CodeStarClient
import software.amazon.awssdk.services.codestarconnections.CodeStarConnectionsClient
import software.amazon.awssdk.services.codestarnotifications.CodestarNotificationsClient
import software.amazon.awssdk.services.cognitoidentity.CognitoIdentityClient
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient
import software.amazon.awssdk.services.cognitosync.CognitoSyncClient
import software.amazon.awssdk.services.comprehend.ComprehendClient
import software.amazon.awssdk.services.comprehendmedical.ComprehendMedicalClient
import software.amazon.awssdk.services.computeoptimizer.ComputeOptimizerClient
import software.amazon.awssdk.services.config.ConfigClient
import software.amazon.awssdk.services.connect.ConnectClient
import software.amazon.awssdk.services.connectcontactlens.ConnectContactLensClient
import software.amazon.awssdk.services.connectparticipant.ConnectParticipantClient
import software.amazon.awssdk.services.costandusagereport.CostAndUsageReportClient
import software.amazon.awssdk.services.costexplorer.CostExplorerClient
import software.amazon.awssdk.services.customerprofiles.CustomerProfilesClient
import software.amazon.awssdk.services.databasemigration.DatabaseMigrationClient
import software.amazon.awssdk.services.databrew.DataBrewClient
import software.amazon.awssdk.services.dataexchange.DataExchangeClient
import software.amazon.awssdk.services.datapipeline.DataPipelineClient
import software.amazon.awssdk.services.datasync.DataSyncClient
import software.amazon.awssdk.services.dax.DaxClient
import software.amazon.awssdk.services.detective.DetectiveClient
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient
import software.amazon.awssdk.services.devopsguru.DevOpsGuruClient
import software.amazon.awssdk.services.directconnect.DirectConnectClient
import software.amazon.awssdk.services.directory.DirectoryClient
import software.amazon.awssdk.services.dlm.DlmClient
import software.amazon.awssdk.services.docdb.DocDbClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient
import software.amazon.awssdk.services.ebs.EbsClient
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.ec2instanceconnect.Ec2InstanceConnectClient
import software.amazon.awssdk.services.ecr.EcrClient
import software.amazon.awssdk.services.ecrpublic.EcrPublicClient
import software.amazon.awssdk.services.ecs.EcsClient
import software.amazon.awssdk.services.efs.EfsClient
import software.amazon.awssdk.services.eks.EksClient
import software.amazon.awssdk.services.elasticache.ElastiCacheClient
import software.amazon.awssdk.services.elasticbeanstalk.ElasticBeanstalkClient
import software.amazon.awssdk.services.elasticinference.ElasticInferenceClient
import software.amazon.awssdk.services.elasticloadbalancing.ElasticLoadBalancingClient
import software.amazon.awssdk.services.elasticloadbalancingv2.ElasticLoadBalancingV2Client
import software.amazon.awssdk.services.elasticsearch.ElasticsearchClient
import software.amazon.awssdk.services.elastictranscoder.ElasticTranscoderClient
import software.amazon.awssdk.services.emr.EmrClient
import software.amazon.awssdk.services.emrcontainers.EmrContainersClient
import software.amazon.awssdk.services.eventbridge.EventBridgeClient
import software.amazon.awssdk.services.finspace.FinspaceClient
import software.amazon.awssdk.services.finspacedata.FinspaceDataClient
import software.amazon.awssdk.services.firehose.FirehoseClient
import software.amazon.awssdk.services.fis.FisClient
import software.amazon.awssdk.services.fms.FmsClient
import software.amazon.awssdk.services.forecast.ForecastClient
import software.amazon.awssdk.services.forecastquery.ForecastqueryClient
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient
import software.amazon.awssdk.services.fsx.FSxClient
import software.amazon.awssdk.services.gamelift.GameLiftClient
import software.amazon.awssdk.services.glacier.GlacierClient
import software.amazon.awssdk.services.globalaccelerator.GlobalAcceleratorClient
import software.amazon.awssdk.services.glue.GlueClient
import software.amazon.awssdk.services.greengrass.GreengrassClient
import software.amazon.awssdk.services.greengrassv2.GreengrassV2Client
import software.amazon.awssdk.services.groundstation.GroundStationClient
import software.amazon.awssdk.services.guardduty.GuardDutyClient
import software.amazon.awssdk.services.health.HealthClient
import software.amazon.awssdk.services.healthlake.HealthLakeClient
import software.amazon.awssdk.services.honeycode.HoneycodeClient
import software.amazon.awssdk.services.iam.IamClient
import software.amazon.awssdk.services.identitystore.IdentitystoreClient
import software.amazon.awssdk.services.imagebuilder.ImagebuilderClient
import software.amazon.awssdk.services.inspector.InspectorClient
import software.amazon.awssdk.services.iot.IotClient
import software.amazon.awssdk.services.iot1clickdevices.Iot1ClickDevicesClient
import software.amazon.awssdk.services.iot1clickprojects.Iot1ClickProjectsClient
import software.amazon.awssdk.services.iotanalytics.IoTAnalyticsClient
import software.amazon.awssdk.services.iotdataplane.IotDataPlaneClient
import software.amazon.awssdk.services.iotdeviceadvisor.IotDeviceAdvisorClient
import software.amazon.awssdk.services.iotevents.IotEventsClient
import software.amazon.awssdk.services.ioteventsdata.IotEventsDataClient
import software.amazon.awssdk.services.iotfleethub.IoTFleetHubClient
import software.amazon.awssdk.services.iotjobsdataplane.IotJobsDataPlaneClient
import software.amazon.awssdk.services.iotsecuretunneling.IoTSecureTunnelingClient
import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient
import software.amazon.awssdk.services.iotthingsgraph.IoTThingsGraphClient
import software.amazon.awssdk.services.iotwireless.IotWirelessClient
import software.amazon.awssdk.services.ivs.IvsClient
import software.amazon.awssdk.services.kafka.KafkaClient
import software.amazon.awssdk.services.kendra.KendraClient
import software.amazon.awssdk.services.kinesis.KinesisClient
import software.amazon.awssdk.services.kinesisanalytics.KinesisAnalyticsClient
import software.amazon.awssdk.services.kinesisanalyticsv2.KinesisAnalyticsV2Client
import software.amazon.awssdk.services.kinesisvideo.KinesisVideoClient
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaClient
import software.amazon.awssdk.services.kinesisvideomedia.KinesisVideoMediaClient
import software.amazon.awssdk.services.kinesisvideosignaling.KinesisVideoSignalingClient
import software.amazon.awssdk.services.kms.KmsClient
import software.amazon.awssdk.services.lakeformation.LakeFormationClient
import software.amazon.awssdk.services.lambda.LambdaClient
import software.amazon.awssdk.services.lexmodelbuilding.LexModelBuildingClient
import software.amazon.awssdk.services.lexmodelsv2.LexModelsV2Client
import software.amazon.awssdk.services.lexruntime.LexRuntimeClient
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client
import software.amazon.awssdk.services.licensemanager.LicenseManagerClient
import software.amazon.awssdk.services.lightsail.LightsailClient
import software.amazon.awssdk.services.location.LocationClient
import software.amazon.awssdk.services.lookoutequipment.LookoutEquipmentClient
import software.amazon.awssdk.services.lookoutmetrics.LookoutMetricsClient
import software.amazon.awssdk.services.lookoutvision.LookoutVisionClient
import software.amazon.awssdk.services.machinelearning.MachineLearningClient
import software.amazon.awssdk.services.macie.MacieClient
import software.amazon.awssdk.services.macie2.Macie2Client
import software.amazon.awssdk.services.managedblockchain.ManagedBlockchainClient
import software.amazon.awssdk.services.marketplacecatalog.MarketplaceCatalogClient
import software.amazon.awssdk.services.marketplacecommerceanalytics.MarketplaceCommerceAnalyticsClient
import software.amazon.awssdk.services.marketplaceentitlement.MarketplaceEntitlementClient
import software.amazon.awssdk.services.marketplacemetering.MarketplaceMeteringClient
import software.amazon.awssdk.services.mediaconnect.MediaConnectClient
import software.amazon.awssdk.services.mediaconvert.MediaConvertClient
import software.amazon.awssdk.services.medialive.MediaLiveClient
import software.amazon.awssdk.services.mediapackage.MediaPackageClient
import software.amazon.awssdk.services.mediapackagevod.MediaPackageVodClient
import software.amazon.awssdk.services.mediastore.MediaStoreClient
import software.amazon.awssdk.services.mediastoredata.MediaStoreDataClient
import software.amazon.awssdk.services.mediatailor.MediaTailorClient
import software.amazon.awssdk.services.mgn.MgnClient
import software.amazon.awssdk.services.migrationhub.MigrationHubClient
import software.amazon.awssdk.services.migrationhubconfig.MigrationHubConfigClient
import software.amazon.awssdk.services.mobile.MobileClient
import software.amazon.awssdk.services.mq.MqClient
import software.amazon.awssdk.services.mturk.MTurkClient
import software.amazon.awssdk.services.mwaa.MwaaClient
import software.amazon.awssdk.services.neptune.NeptuneClient
import software.amazon.awssdk.services.networkfirewall.NetworkFirewallClient
import software.amazon.awssdk.services.networkmanager.NetworkManagerClient
import software.amazon.awssdk.services.nimble.NimbleClient
import software.amazon.awssdk.services.opsworks.OpsWorksClient
import software.amazon.awssdk.services.opsworkscm.OpsWorksCmClient
import software.amazon.awssdk.services.organizations.OrganizationsClient
import software.amazon.awssdk.services.outposts.OutpostsClient
import software.amazon.awssdk.services.personalize.PersonalizeClient
import software.amazon.awssdk.services.personalizeevents.PersonalizeEventsClient
import software.amazon.awssdk.services.personalizeruntime.PersonalizeRuntimeClient
import software.amazon.awssdk.services.pi.PiClient
import software.amazon.awssdk.services.pinpoint.PinpointClient
import software.amazon.awssdk.services.pinpointemail.PinpointEmailClient
import software.amazon.awssdk.services.pinpointsmsvoice.PinpointSmsVoiceClient
import software.amazon.awssdk.services.polly.PollyClient
import software.amazon.awssdk.services.pricing.PricingClient
import software.amazon.awssdk.services.proton.ProtonClient
import software.amazon.awssdk.services.qldb.QldbClient
import software.amazon.awssdk.services.qldbsession.QldbSessionClient
import software.amazon.awssdk.services.quicksight.QuickSightClient
import software.amazon.awssdk.services.ram.RamClient
import software.amazon.awssdk.services.rds.RdsClient
import software.amazon.awssdk.services.rdsdata.RdsDataClient
import software.amazon.awssdk.services.redshift.RedshiftClient
import software.amazon.awssdk.services.redshiftdata.RedshiftDataClient
import software.amazon.awssdk.services.rekognition.RekognitionClient
import software.amazon.awssdk.services.resourcegroups.ResourceGroupsClient
import software.amazon.awssdk.services.resourcegroupstaggingapi.ResourceGroupsTaggingApiClient
import software.amazon.awssdk.services.robomaker.RoboMakerClient
import software.amazon.awssdk.services.route53.Route53Client
import software.amazon.awssdk.services.route53domains.Route53DomainsClient
import software.amazon.awssdk.services.route53resolver.Route53ResolverClient
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3control.S3ControlClient
import software.amazon.awssdk.services.s3outposts.S3OutpostsClient
import software.amazon.awssdk.services.sagemaker.SageMakerClient
import software.amazon.awssdk.services.sagemakera2iruntime.SageMakerA2IRuntimeClient
import software.amazon.awssdk.services.sagemakeredge.SagemakerEdgeClient
import software.amazon.awssdk.services.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeClient
import software.amazon.awssdk.services.sagemakerruntime.SageMakerRuntimeClient
import software.amazon.awssdk.services.savingsplans.SavingsplansClient
import software.amazon.awssdk.services.schemas.SchemasClient
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.securityhub.SecurityHubClient
import software.amazon.awssdk.services.serverlessapplicationrepository.ServerlessApplicationRepositoryClient
import software.amazon.awssdk.services.servicecatalog.ServiceCatalogClient
import software.amazon.awssdk.services.servicecatalogappregistry.ServiceCatalogAppRegistryClient
import software.amazon.awssdk.services.servicediscovery.ServiceDiscoveryClient
import software.amazon.awssdk.services.servicequotas.ServiceQuotasClient
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.sesv2.SesV2Client
import software.amazon.awssdk.services.sfn.SfnClient
import software.amazon.awssdk.services.shield.ShieldClient
import software.amazon.awssdk.services.signer.SignerClient
import software.amazon.awssdk.services.sms.SmsClient
import software.amazon.awssdk.services.snowball.SnowballClient
import software.amazon.awssdk.services.sns.SnsClient
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.ssm.SsmClient
import software.amazon.awssdk.services.ssmcontacts.SsmContactsClient
import software.amazon.awssdk.services.ssmincidents.SsmIncidentsClient
import software.amazon.awssdk.services.sso.SsoClient
import software.amazon.awssdk.services.ssoadmin.SsoAdminClient
import software.amazon.awssdk.services.ssooidc.SsoOidcClient
import software.amazon.awssdk.services.storagegateway.StorageGatewayClient
import software.amazon.awssdk.services.sts.StsClient
import software.amazon.awssdk.services.support.SupportClient
import software.amazon.awssdk.services.swf.SwfClient
import software.amazon.awssdk.services.synthetics.SyntheticsClient
import software.amazon.awssdk.services.textract.TextractClient
import software.amazon.awssdk.services.timestreamquery.TimestreamQueryClient
import software.amazon.awssdk.services.timestreamwrite.TimestreamWriteClient
import software.amazon.awssdk.services.transcribe.TranscribeClient
import software.amazon.awssdk.services.transfer.TransferClient
import software.amazon.awssdk.services.translate.TranslateClient
import software.amazon.awssdk.services.waf.WafClient
import software.amazon.awssdk.services.waf.regional.WafRegionalClient
import software.amazon.awssdk.services.wafv2.Wafv2Client
import software.amazon.awssdk.services.wellarchitected.WellArchitectedClient
import software.amazon.awssdk.services.workdocs.WorkDocsClient
import software.amazon.awssdk.services.worklink.WorkLinkClient
import software.amazon.awssdk.services.workmail.WorkMailClient
import software.amazon.awssdk.services.workmailmessageflow.WorkMailMessageFlowClient
import software.amazon.awssdk.services.workspaces.WorkSpacesClient
import software.amazon.awssdk.services.xray.XRayClient


// A pair (J, Free[F, A]) with constructors that tie down J and F.
sealed trait Embedded[A]

object Embedded {
  final case class AccessAnalyzer[A](client: AccessAnalyzerClient, io: AccessAnalyzerIO[A]) extends Embedded[A]
  final case class Acm[A](client: AcmClient, io: AcmIO[A]) extends Embedded[A]
  final case class AcmPca[A](client: AcmPcaClient, io: AcmPcaIO[A]) extends Embedded[A]
  final case class AlexaForBusiness[A](client: AlexaForBusinessClient, io: AlexaForBusinessIO[A]) extends Embedded[A]
  final case class Amp[A](client: AmpClient, io: AmpIO[A]) extends Embedded[A]
  final case class Amplify[A](client: AmplifyClient, io: AmplifyIO[A]) extends Embedded[A]
  final case class AmplifyBackend[A](client: AmplifyBackendClient, io: AmplifyBackendIO[A]) extends Embedded[A]
  final case class ApiGateway[A](client: ApiGatewayClient, io: ApiGatewayIO[A]) extends Embedded[A]
  final case class ApiGatewayManagementApi[A](client: ApiGatewayManagementApiClient, io: ApiGatewayManagementApiIO[A]) extends Embedded[A]
  final case class ApiGatewayV2[A](client: ApiGatewayV2Client, io: ApiGatewayV2IO[A]) extends Embedded[A]
  final case class AppConfig[A](client: AppConfigClient, io: AppConfigIO[A]) extends Embedded[A]
  final case class Appflow[A](client: AppflowClient, io: AppflowIO[A]) extends Embedded[A]
  final case class AppIntegrations[A](client: AppIntegrationsClient, io: AppIntegrationsIO[A]) extends Embedded[A]
  final case class ApplicationAutoScaling[A](client: ApplicationAutoScalingClient, io: ApplicationAutoScalingIO[A]) extends Embedded[A]
  final case class ApplicationCostProfiler[A](client: ApplicationCostProfilerClient, io: ApplicationCostProfilerIO[A]) extends Embedded[A]
  final case class ApplicationDiscovery[A](client: ApplicationDiscoveryClient, io: ApplicationDiscoveryIO[A]) extends Embedded[A]
  final case class ApplicationInsights[A](client: ApplicationInsightsClient, io: ApplicationInsightsIO[A]) extends Embedded[A]
  final case class AppMesh[A](client: AppMeshClient, io: AppMeshIO[A]) extends Embedded[A]
  final case class AppRunner[A](client: AppRunnerClient, io: AppRunnerIO[A]) extends Embedded[A]
  final case class AppStream[A](client: AppStreamClient, io: AppStreamIO[A]) extends Embedded[A]
  final case class AppSync[A](client: AppSyncClient, io: AppSyncIO[A]) extends Embedded[A]
  final case class Athena[A](client: AthenaClient, io: AthenaIO[A]) extends Embedded[A]
  final case class AuditManager[A](client: AuditManagerClient, io: AuditManagerIO[A]) extends Embedded[A]
  final case class AutoScaling[A](client: AutoScalingClient, io: AutoScalingIO[A]) extends Embedded[A]
  final case class AutoScalingPlans[A](client: AutoScalingPlansClient, io: AutoScalingPlansIO[A]) extends Embedded[A]
  final case class Backup[A](client: BackupClient, io: BackupIO[A]) extends Embedded[A]
  final case class Batch[A](client: BatchClient, io: BatchIO[A]) extends Embedded[A]
  final case class Braket[A](client: BraketClient, io: BraketIO[A]) extends Embedded[A]
  final case class Budgets[A](client: BudgetsClient, io: BudgetsIO[A]) extends Embedded[A]
  final case class Chime[A](client: ChimeClient, io: ChimeIO[A]) extends Embedded[A]
  final case class Cloud9[A](client: Cloud9Client, io: Cloud9IO[A]) extends Embedded[A]
  final case class CloudDirectory[A](client: CloudDirectoryClient, io: CloudDirectoryIO[A]) extends Embedded[A]
  final case class CloudFormation[A](client: CloudFormationClient, io: CloudFormationIO[A]) extends Embedded[A]
  final case class CloudFront[A](client: CloudFrontClient, io: CloudFrontIO[A]) extends Embedded[A]
  final case class CloudHsm[A](client: CloudHsmClient, io: CloudHsmIO[A]) extends Embedded[A]
  final case class CloudHsmV2[A](client: CloudHsmV2Client, io: CloudHsmV2IO[A]) extends Embedded[A]
  final case class CloudSearch[A](client: CloudSearchClient, io: CloudSearchIO[A]) extends Embedded[A]
  final case class CloudSearchDomain[A](client: CloudSearchDomainClient, io: CloudSearchDomainIO[A]) extends Embedded[A]
  final case class CloudTrail[A](client: CloudTrailClient, io: CloudTrailIO[A]) extends Embedded[A]
  final case class CloudWatch[A](client: CloudWatchClient, io: CloudWatchIO[A]) extends Embedded[A]
  final case class CloudWatchEvents[A](client: CloudWatchEventsClient, io: CloudWatchEventsIO[A]) extends Embedded[A]
  final case class CloudWatchLogs[A](client: CloudWatchLogsClient, io: CloudWatchLogsIO[A]) extends Embedded[A]
  final case class Codeartifact[A](client: CodeartifactClient, io: CodeartifactIO[A]) extends Embedded[A]
  final case class CodeBuild[A](client: CodeBuildClient, io: CodeBuildIO[A]) extends Embedded[A]
  final case class CodeCommit[A](client: CodeCommitClient, io: CodeCommitIO[A]) extends Embedded[A]
  final case class CodeDeploy[A](client: CodeDeployClient, io: CodeDeployIO[A]) extends Embedded[A]
  final case class CodeGuruProfiler[A](client: CodeGuruProfilerClient, io: CodeGuruProfilerIO[A]) extends Embedded[A]
  final case class CodeGuruReviewer[A](client: CodeGuruReviewerClient, io: CodeGuruReviewerIO[A]) extends Embedded[A]
  final case class CodePipeline[A](client: CodePipelineClient, io: CodePipelineIO[A]) extends Embedded[A]
  final case class CodeStar[A](client: CodeStarClient, io: CodeStarIO[A]) extends Embedded[A]
  final case class CodeStarConnections[A](client: CodeStarConnectionsClient, io: CodeStarConnectionsIO[A]) extends Embedded[A]
  final case class CodestarNotifications[A](client: CodestarNotificationsClient, io: CodestarNotificationsIO[A]) extends Embedded[A]
  final case class CognitoIdentity[A](client: CognitoIdentityClient, io: CognitoIdentityIO[A]) extends Embedded[A]
  final case class CognitoIdentityProvider[A](client: CognitoIdentityProviderClient, io: CognitoIdentityProviderIO[A]) extends Embedded[A]
  final case class CognitoSync[A](client: CognitoSyncClient, io: CognitoSyncIO[A]) extends Embedded[A]
  final case class Comprehend[A](client: ComprehendClient, io: ComprehendIO[A]) extends Embedded[A]
  final case class ComprehendMedical[A](client: ComprehendMedicalClient, io: ComprehendMedicalIO[A]) extends Embedded[A]
  final case class ComputeOptimizer[A](client: ComputeOptimizerClient, io: ComputeOptimizerIO[A]) extends Embedded[A]
  final case class Config[A](client: ConfigClient, io: ConfigIO[A]) extends Embedded[A]
  final case class Connect[A](client: ConnectClient, io: ConnectIO[A]) extends Embedded[A]
  final case class ConnectContactLens[A](client: ConnectContactLensClient, io: ConnectContactLensIO[A]) extends Embedded[A]
  final case class ConnectParticipant[A](client: ConnectParticipantClient, io: ConnectParticipantIO[A]) extends Embedded[A]
  final case class CostAndUsageReport[A](client: CostAndUsageReportClient, io: CostAndUsageReportIO[A]) extends Embedded[A]
  final case class CostExplorer[A](client: CostExplorerClient, io: CostExplorerIO[A]) extends Embedded[A]
  final case class CustomerProfiles[A](client: CustomerProfilesClient, io: CustomerProfilesIO[A]) extends Embedded[A]
  final case class DatabaseMigration[A](client: DatabaseMigrationClient, io: DatabaseMigrationIO[A]) extends Embedded[A]
  final case class DataBrew[A](client: DataBrewClient, io: DataBrewIO[A]) extends Embedded[A]
  final case class DataExchange[A](client: DataExchangeClient, io: DataExchangeIO[A]) extends Embedded[A]
  final case class DataPipeline[A](client: DataPipelineClient, io: DataPipelineIO[A]) extends Embedded[A]
  final case class DataSync[A](client: DataSyncClient, io: DataSyncIO[A]) extends Embedded[A]
  final case class Dax[A](client: DaxClient, io: DaxIO[A]) extends Embedded[A]
  final case class Detective[A](client: DetectiveClient, io: DetectiveIO[A]) extends Embedded[A]
  final case class DeviceFarm[A](client: DeviceFarmClient, io: DeviceFarmIO[A]) extends Embedded[A]
  final case class DevOpsGuru[A](client: DevOpsGuruClient, io: DevOpsGuruIO[A]) extends Embedded[A]
  final case class DirectConnect[A](client: DirectConnectClient, io: DirectConnectIO[A]) extends Embedded[A]
  final case class Directory[A](client: DirectoryClient, io: DirectoryIO[A]) extends Embedded[A]
  final case class Dlm[A](client: DlmClient, io: DlmIO[A]) extends Embedded[A]
  final case class DocDb[A](client: DocDbClient, io: DocDbIO[A]) extends Embedded[A]
  final case class DynamoDb[A](client: DynamoDbClient, io: DynamoDbIO[A]) extends Embedded[A]
  final case class DynamoDbStreams[A](client: DynamoDbStreamsClient, io: DynamoDbStreamsIO[A]) extends Embedded[A]
  final case class Ebs[A](client: EbsClient, io: EbsIO[A]) extends Embedded[A]
  final case class Ec2[A](client: Ec2Client, io: Ec2IO[A]) extends Embedded[A]
  final case class Ec2InstanceConnect[A](client: Ec2InstanceConnectClient, io: Ec2InstanceConnectIO[A]) extends Embedded[A]
  final case class Ecr[A](client: EcrClient, io: EcrIO[A]) extends Embedded[A]
  final case class EcrPublic[A](client: EcrPublicClient, io: EcrPublicIO[A]) extends Embedded[A]
  final case class Ecs[A](client: EcsClient, io: EcsIO[A]) extends Embedded[A]
  final case class Efs[A](client: EfsClient, io: EfsIO[A]) extends Embedded[A]
  final case class Eks[A](client: EksClient, io: EksIO[A]) extends Embedded[A]
  final case class ElastiCache[A](client: ElastiCacheClient, io: ElastiCacheIO[A]) extends Embedded[A]
  final case class ElasticBeanstalk[A](client: ElasticBeanstalkClient, io: ElasticBeanstalkIO[A]) extends Embedded[A]
  final case class ElasticInference[A](client: ElasticInferenceClient, io: ElasticInferenceIO[A]) extends Embedded[A]
  final case class ElasticLoadBalancing[A](client: ElasticLoadBalancingClient, io: ElasticLoadBalancingIO[A]) extends Embedded[A]
  final case class ElasticLoadBalancingV2[A](client: ElasticLoadBalancingV2Client, io: ElasticLoadBalancingV2IO[A]) extends Embedded[A]
  final case class Elasticsearch[A](client: ElasticsearchClient, io: ElasticsearchIO[A]) extends Embedded[A]
  final case class ElasticTranscoder[A](client: ElasticTranscoderClient, io: ElasticTranscoderIO[A]) extends Embedded[A]
  final case class Emr[A](client: EmrClient, io: EmrIO[A]) extends Embedded[A]
  final case class EmrContainers[A](client: EmrContainersClient, io: EmrContainersIO[A]) extends Embedded[A]
  final case class EventBridge[A](client: EventBridgeClient, io: EventBridgeIO[A]) extends Embedded[A]
  final case class Finspace[A](client: FinspaceClient, io: FinspaceIO[A]) extends Embedded[A]
  final case class FinspaceData[A](client: FinspaceDataClient, io: FinspaceDataIO[A]) extends Embedded[A]
  final case class Firehose[A](client: FirehoseClient, io: FirehoseIO[A]) extends Embedded[A]
  final case class Fis[A](client: FisClient, io: FisIO[A]) extends Embedded[A]
  final case class Fms[A](client: FmsClient, io: FmsIO[A]) extends Embedded[A]
  final case class Forecast[A](client: ForecastClient, io: ForecastIO[A]) extends Embedded[A]
  final case class Forecastquery[A](client: ForecastqueryClient, io: ForecastqueryIO[A]) extends Embedded[A]
  final case class FraudDetector[A](client: FraudDetectorClient, io: FraudDetectorIO[A]) extends Embedded[A]
  final case class FSx[A](client: FSxClient, io: FSxIO[A]) extends Embedded[A]
  final case class GameLift[A](client: GameLiftClient, io: GameLiftIO[A]) extends Embedded[A]
  final case class Glacier[A](client: GlacierClient, io: GlacierIO[A]) extends Embedded[A]
  final case class GlobalAccelerator[A](client: GlobalAcceleratorClient, io: GlobalAcceleratorIO[A]) extends Embedded[A]
  final case class Glue[A](client: GlueClient, io: GlueIO[A]) extends Embedded[A]
  final case class Greengrass[A](client: GreengrassClient, io: GreengrassIO[A]) extends Embedded[A]
  final case class GreengrassV2[A](client: GreengrassV2Client, io: GreengrassV2IO[A]) extends Embedded[A]
  final case class GroundStation[A](client: GroundStationClient, io: GroundStationIO[A]) extends Embedded[A]
  final case class GuardDuty[A](client: GuardDutyClient, io: GuardDutyIO[A]) extends Embedded[A]
  final case class Health[A](client: HealthClient, io: HealthIO[A]) extends Embedded[A]
  final case class HealthLake[A](client: HealthLakeClient, io: HealthLakeIO[A]) extends Embedded[A]
  final case class Honeycode[A](client: HoneycodeClient, io: HoneycodeIO[A]) extends Embedded[A]
  final case class Iam[A](client: IamClient, io: IamIO[A]) extends Embedded[A]
  final case class Identitystore[A](client: IdentitystoreClient, io: IdentitystoreIO[A]) extends Embedded[A]
  final case class Imagebuilder[A](client: ImagebuilderClient, io: ImagebuilderIO[A]) extends Embedded[A]
  final case class Inspector[A](client: InspectorClient, io: InspectorIO[A]) extends Embedded[A]
  final case class Iot[A](client: IotClient, io: IotIO[A]) extends Embedded[A]
  final case class Iot1ClickDevices[A](client: Iot1ClickDevicesClient, io: Iot1ClickDevicesIO[A]) extends Embedded[A]
  final case class Iot1ClickProjects[A](client: Iot1ClickProjectsClient, io: Iot1ClickProjectsIO[A]) extends Embedded[A]
  final case class IoTAnalytics[A](client: IoTAnalyticsClient, io: IoTAnalyticsIO[A]) extends Embedded[A]
  final case class IotDataPlane[A](client: IotDataPlaneClient, io: IotDataPlaneIO[A]) extends Embedded[A]
  final case class IotDeviceAdvisor[A](client: IotDeviceAdvisorClient, io: IotDeviceAdvisorIO[A]) extends Embedded[A]
  final case class IotEvents[A](client: IotEventsClient, io: IotEventsIO[A]) extends Embedded[A]
  final case class IotEventsData[A](client: IotEventsDataClient, io: IotEventsDataIO[A]) extends Embedded[A]
  final case class IoTFleetHub[A](client: IoTFleetHubClient, io: IoTFleetHubIO[A]) extends Embedded[A]
  final case class IotJobsDataPlane[A](client: IotJobsDataPlaneClient, io: IotJobsDataPlaneIO[A]) extends Embedded[A]
  final case class IoTSecureTunneling[A](client: IoTSecureTunnelingClient, io: IoTSecureTunnelingIO[A]) extends Embedded[A]
  final case class IoTSiteWise[A](client: IoTSiteWiseClient, io: IoTSiteWiseIO[A]) extends Embedded[A]
  final case class IoTThingsGraph[A](client: IoTThingsGraphClient, io: IoTThingsGraphIO[A]) extends Embedded[A]
  final case class IotWireless[A](client: IotWirelessClient, io: IotWirelessIO[A]) extends Embedded[A]
  final case class Ivs[A](client: IvsClient, io: IvsIO[A]) extends Embedded[A]
  final case class Kafka[A](client: KafkaClient, io: KafkaIO[A]) extends Embedded[A]
  final case class Kendra[A](client: KendraClient, io: KendraIO[A]) extends Embedded[A]
  final case class Kinesis[A](client: KinesisClient, io: KinesisIO[A]) extends Embedded[A]
  final case class KinesisAnalytics[A](client: KinesisAnalyticsClient, io: KinesisAnalyticsIO[A]) extends Embedded[A]
  final case class KinesisAnalyticsV2[A](client: KinesisAnalyticsV2Client, io: KinesisAnalyticsV2IO[A]) extends Embedded[A]
  final case class KinesisVideo[A](client: KinesisVideoClient, io: KinesisVideoIO[A]) extends Embedded[A]
  final case class KinesisVideoArchivedMedia[A](client: KinesisVideoArchivedMediaClient, io: KinesisVideoArchivedMediaIO[A]) extends Embedded[A]
  final case class KinesisVideoMedia[A](client: KinesisVideoMediaClient, io: KinesisVideoMediaIO[A]) extends Embedded[A]
  final case class KinesisVideoSignaling[A](client: KinesisVideoSignalingClient, io: KinesisVideoSignalingIO[A]) extends Embedded[A]
  final case class Kms[A](client: KmsClient, io: KmsIO[A]) extends Embedded[A]
  final case class LakeFormation[A](client: LakeFormationClient, io: LakeFormationIO[A]) extends Embedded[A]
  final case class Lambda[A](client: LambdaClient, io: LambdaIO[A]) extends Embedded[A]
  final case class LexModelBuilding[A](client: LexModelBuildingClient, io: LexModelBuildingIO[A]) extends Embedded[A]
  final case class LexModelsV2[A](client: LexModelsV2Client, io: LexModelsV2IO[A]) extends Embedded[A]
  final case class LexRuntime[A](client: LexRuntimeClient, io: LexRuntimeIO[A]) extends Embedded[A]
  final case class LexRuntimeV2[A](client: LexRuntimeV2Client, io: LexRuntimeV2IO[A]) extends Embedded[A]
  final case class LicenseManager[A](client: LicenseManagerClient, io: LicenseManagerIO[A]) extends Embedded[A]
  final case class Lightsail[A](client: LightsailClient, io: LightsailIO[A]) extends Embedded[A]
  final case class Location[A](client: LocationClient, io: LocationIO[A]) extends Embedded[A]
  final case class LookoutEquipment[A](client: LookoutEquipmentClient, io: LookoutEquipmentIO[A]) extends Embedded[A]
  final case class LookoutMetrics[A](client: LookoutMetricsClient, io: LookoutMetricsIO[A]) extends Embedded[A]
  final case class LookoutVision[A](client: LookoutVisionClient, io: LookoutVisionIO[A]) extends Embedded[A]
  final case class MachineLearning[A](client: MachineLearningClient, io: MachineLearningIO[A]) extends Embedded[A]
  final case class Macie[A](client: MacieClient, io: MacieIO[A]) extends Embedded[A]
  final case class Macie2[A](client: Macie2Client, io: Macie2IO[A]) extends Embedded[A]
  final case class ManagedBlockchain[A](client: ManagedBlockchainClient, io: ManagedBlockchainIO[A]) extends Embedded[A]
  final case class MarketplaceCatalog[A](client: MarketplaceCatalogClient, io: MarketplaceCatalogIO[A]) extends Embedded[A]
  final case class MarketplaceCommerceAnalytics[A](client: MarketplaceCommerceAnalyticsClient, io: MarketplaceCommerceAnalyticsIO[A]) extends Embedded[A]
  final case class MarketplaceEntitlement[A](client: MarketplaceEntitlementClient, io: MarketplaceEntitlementIO[A]) extends Embedded[A]
  final case class MarketplaceMetering[A](client: MarketplaceMeteringClient, io: MarketplaceMeteringIO[A]) extends Embedded[A]
  final case class MediaConnect[A](client: MediaConnectClient, io: MediaConnectIO[A]) extends Embedded[A]
  final case class MediaConvert[A](client: MediaConvertClient, io: MediaConvertIO[A]) extends Embedded[A]
  final case class MediaLive[A](client: MediaLiveClient, io: MediaLiveIO[A]) extends Embedded[A]
  final case class MediaPackage[A](client: MediaPackageClient, io: MediaPackageIO[A]) extends Embedded[A]
  final case class MediaPackageVod[A](client: MediaPackageVodClient, io: MediaPackageVodIO[A]) extends Embedded[A]
  final case class MediaStore[A](client: MediaStoreClient, io: MediaStoreIO[A]) extends Embedded[A]
  final case class MediaStoreData[A](client: MediaStoreDataClient, io: MediaStoreDataIO[A]) extends Embedded[A]
  final case class MediaTailor[A](client: MediaTailorClient, io: MediaTailorIO[A]) extends Embedded[A]
  final case class Mgn[A](client: MgnClient, io: MgnIO[A]) extends Embedded[A]
  final case class MigrationHub[A](client: MigrationHubClient, io: MigrationHubIO[A]) extends Embedded[A]
  final case class MigrationHubConfig[A](client: MigrationHubConfigClient, io: MigrationHubConfigIO[A]) extends Embedded[A]
  final case class Mobile[A](client: MobileClient, io: MobileIO[A]) extends Embedded[A]
  final case class Mq[A](client: MqClient, io: MqIO[A]) extends Embedded[A]
  final case class MTurk[A](client: MTurkClient, io: MTurkIO[A]) extends Embedded[A]
  final case class Mwaa[A](client: MwaaClient, io: MwaaIO[A]) extends Embedded[A]
  final case class Neptune[A](client: NeptuneClient, io: NeptuneIO[A]) extends Embedded[A]
  final case class NetworkFirewall[A](client: NetworkFirewallClient, io: NetworkFirewallIO[A]) extends Embedded[A]
  final case class NetworkManager[A](client: NetworkManagerClient, io: NetworkManagerIO[A]) extends Embedded[A]
  final case class Nimble[A](client: NimbleClient, io: NimbleIO[A]) extends Embedded[A]
  final case class OpsWorks[A](client: OpsWorksClient, io: OpsWorksIO[A]) extends Embedded[A]
  final case class OpsWorksCm[A](client: OpsWorksCmClient, io: OpsWorksCmIO[A]) extends Embedded[A]
  final case class Organizations[A](client: OrganizationsClient, io: OrganizationsIO[A]) extends Embedded[A]
  final case class Outposts[A](client: OutpostsClient, io: OutpostsIO[A]) extends Embedded[A]
  final case class Personalize[A](client: PersonalizeClient, io: PersonalizeIO[A]) extends Embedded[A]
  final case class PersonalizeEvents[A](client: PersonalizeEventsClient, io: PersonalizeEventsIO[A]) extends Embedded[A]
  final case class PersonalizeRuntime[A](client: PersonalizeRuntimeClient, io: PersonalizeRuntimeIO[A]) extends Embedded[A]
  final case class Pi[A](client: PiClient, io: PiIO[A]) extends Embedded[A]
  final case class Pinpoint[A](client: PinpointClient, io: PinpointIO[A]) extends Embedded[A]
  final case class PinpointEmail[A](client: PinpointEmailClient, io: PinpointEmailIO[A]) extends Embedded[A]
  final case class PinpointSmsVoice[A](client: PinpointSmsVoiceClient, io: PinpointSmsVoiceIO[A]) extends Embedded[A]
  final case class Polly[A](client: PollyClient, io: PollyIO[A]) extends Embedded[A]
  final case class Pricing[A](client: PricingClient, io: PricingIO[A]) extends Embedded[A]
  final case class Proton[A](client: ProtonClient, io: ProtonIO[A]) extends Embedded[A]
  final case class Qldb[A](client: QldbClient, io: QldbIO[A]) extends Embedded[A]
  final case class QldbSession[A](client: QldbSessionClient, io: QldbSessionIO[A]) extends Embedded[A]
  final case class QuickSight[A](client: QuickSightClient, io: QuickSightIO[A]) extends Embedded[A]
  final case class Ram[A](client: RamClient, io: RamIO[A]) extends Embedded[A]
  final case class Rds[A](client: RdsClient, io: RdsIO[A]) extends Embedded[A]
  final case class RdsData[A](client: RdsDataClient, io: RdsDataIO[A]) extends Embedded[A]
  final case class Redshift[A](client: RedshiftClient, io: RedshiftIO[A]) extends Embedded[A]
  final case class RedshiftData[A](client: RedshiftDataClient, io: RedshiftDataIO[A]) extends Embedded[A]
  final case class Rekognition[A](client: RekognitionClient, io: RekognitionIO[A]) extends Embedded[A]
  final case class ResourceGroups[A](client: ResourceGroupsClient, io: ResourceGroupsIO[A]) extends Embedded[A]
  final case class ResourceGroupsTaggingApi[A](client: ResourceGroupsTaggingApiClient, io: ResourceGroupsTaggingApiIO[A]) extends Embedded[A]
  final case class RoboMaker[A](client: RoboMakerClient, io: RoboMakerIO[A]) extends Embedded[A]
  final case class Route53[A](client: Route53Client, io: Route53IO[A]) extends Embedded[A]
  final case class Route53Domains[A](client: Route53DomainsClient, io: Route53DomainsIO[A]) extends Embedded[A]
  final case class Route53Resolver[A](client: Route53ResolverClient, io: Route53ResolverIO[A]) extends Embedded[A]
  final case class S3[A](client: S3Client, io: S3IO[A]) extends Embedded[A]
  final case class S3Control[A](client: S3ControlClient, io: S3ControlIO[A]) extends Embedded[A]
  final case class S3Outposts[A](client: S3OutpostsClient, io: S3OutpostsIO[A]) extends Embedded[A]
  final case class SageMaker[A](client: SageMakerClient, io: SageMakerIO[A]) extends Embedded[A]
  final case class SageMakerA2IRuntime[A](client: SageMakerA2IRuntimeClient, io: SageMakerA2IRuntimeIO[A]) extends Embedded[A]
  final case class SagemakerEdge[A](client: SagemakerEdgeClient, io: SagemakerEdgeIO[A]) extends Embedded[A]
  final case class SageMakerFeatureStoreRuntime[A](client: SageMakerFeatureStoreRuntimeClient, io: SageMakerFeatureStoreRuntimeIO[A]) extends Embedded[A]
  final case class SageMakerRuntime[A](client: SageMakerRuntimeClient, io: SageMakerRuntimeIO[A]) extends Embedded[A]
  final case class Savingsplans[A](client: SavingsplansClient, io: SavingsplansIO[A]) extends Embedded[A]
  final case class Schemas[A](client: SchemasClient, io: SchemasIO[A]) extends Embedded[A]
  final case class SecretsManager[A](client: SecretsManagerClient, io: SecretsManagerIO[A]) extends Embedded[A]
  final case class SecurityHub[A](client: SecurityHubClient, io: SecurityHubIO[A]) extends Embedded[A]
  final case class ServerlessApplicationRepository[A](client: ServerlessApplicationRepositoryClient, io: ServerlessApplicationRepositoryIO[A]) extends Embedded[A]
  final case class ServiceCatalog[A](client: ServiceCatalogClient, io: ServiceCatalogIO[A]) extends Embedded[A]
  final case class ServiceCatalogAppRegistry[A](client: ServiceCatalogAppRegistryClient, io: ServiceCatalogAppRegistryIO[A]) extends Embedded[A]
  final case class ServiceDiscovery[A](client: ServiceDiscoveryClient, io: ServiceDiscoveryIO[A]) extends Embedded[A]
  final case class ServiceQuotas[A](client: ServiceQuotasClient, io: ServiceQuotasIO[A]) extends Embedded[A]
  final case class Ses[A](client: SesClient, io: SesIO[A]) extends Embedded[A]
  final case class SesV2[A](client: SesV2Client, io: SesV2IO[A]) extends Embedded[A]
  final case class Sfn[A](client: SfnClient, io: SfnIO[A]) extends Embedded[A]
  final case class Shield[A](client: ShieldClient, io: ShieldIO[A]) extends Embedded[A]
  final case class Signer[A](client: SignerClient, io: SignerIO[A]) extends Embedded[A]
  final case class Sms[A](client: SmsClient, io: SmsIO[A]) extends Embedded[A]
  final case class Snowball[A](client: SnowballClient, io: SnowballIO[A]) extends Embedded[A]
  final case class Sns[A](client: SnsClient, io: SnsIO[A]) extends Embedded[A]
  final case class Sqs[A](client: SqsClient, io: SqsIO[A]) extends Embedded[A]
  final case class Ssm[A](client: SsmClient, io: SsmIO[A]) extends Embedded[A]
  final case class SsmContacts[A](client: SsmContactsClient, io: SsmContactsIO[A]) extends Embedded[A]
  final case class SsmIncidents[A](client: SsmIncidentsClient, io: SsmIncidentsIO[A]) extends Embedded[A]
  final case class Sso[A](client: SsoClient, io: SsoIO[A]) extends Embedded[A]
  final case class SsoAdmin[A](client: SsoAdminClient, io: SsoAdminIO[A]) extends Embedded[A]
  final case class SsoOidc[A](client: SsoOidcClient, io: SsoOidcIO[A]) extends Embedded[A]
  final case class StorageGateway[A](client: StorageGatewayClient, io: StorageGatewayIO[A]) extends Embedded[A]
  final case class Sts[A](client: StsClient, io: StsIO[A]) extends Embedded[A]
  final case class Support[A](client: SupportClient, io: SupportIO[A]) extends Embedded[A]
  final case class Swf[A](client: SwfClient, io: SwfIO[A]) extends Embedded[A]
  final case class Synthetics[A](client: SyntheticsClient, io: SyntheticsIO[A]) extends Embedded[A]
  final case class Textract[A](client: TextractClient, io: TextractIO[A]) extends Embedded[A]
  final case class TimestreamQuery[A](client: TimestreamQueryClient, io: TimestreamQueryIO[A]) extends Embedded[A]
  final case class TimestreamWrite[A](client: TimestreamWriteClient, io: TimestreamWriteIO[A]) extends Embedded[A]
  final case class Transcribe[A](client: TranscribeClient, io: TranscribeIO[A]) extends Embedded[A]
  final case class Transfer[A](client: TransferClient, io: TransferIO[A]) extends Embedded[A]
  final case class Translate[A](client: TranslateClient, io: TranslateIO[A]) extends Embedded[A]
  final case class Waf[A](client: WafClient, io: WafIO[A]) extends Embedded[A]
  final case class WafRegional[A](client: WafRegionalClient, io: WafRegionalIO[A]) extends Embedded[A]
  final case class Wafv2[A](client: Wafv2Client, io: Wafv2IO[A]) extends Embedded[A]
  final case class WellArchitected[A](client: WellArchitectedClient, io: WellArchitectedIO[A]) extends Embedded[A]
  final case class WorkDocs[A](client: WorkDocsClient, io: WorkDocsIO[A]) extends Embedded[A]
  final case class WorkLink[A](client: WorkLinkClient, io: WorkLinkIO[A]) extends Embedded[A]
  final case class WorkMail[A](client: WorkMailClient, io: WorkMailIO[A]) extends Embedded[A]
  final case class WorkMailMessageFlow[A](client: WorkMailMessageFlowClient, io: WorkMailMessageFlowIO[A]) extends Embedded[A]
  final case class WorkSpaces[A](client: WorkSpacesClient, io: WorkSpacesIO[A]) extends Embedded[A]
  final case class XRay[A](client: XRayClient, io: XRayIO[A]) extends Embedded[A]
}

// Typeclass for embeddable pairs (J, F)
trait Embeddable[F[_], J] {
  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
}
