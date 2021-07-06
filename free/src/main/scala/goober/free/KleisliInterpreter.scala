package goober.free

import scala.language.higherKinds

import cats.data.Kleisli
import cats.effect.{Async, Blocker, ContextShift}
import cats.~>
import goober.free.accessanalyzer.AccessAnalyzerOp
import goober.free.acm.AcmOp
import goober.free.acmpca.AcmPcaOp
import goober.free.alexaforbusiness.AlexaForBusinessOp
import goober.free.amp.AmpOp
import goober.free.amplify.AmplifyOp
import goober.free.amplifybackend.AmplifyBackendOp
import goober.free.apigateway.ApiGatewayOp
import goober.free.apigatewaymanagementapi.ApiGatewayManagementApiOp
import goober.free.apigatewayv2.ApiGatewayV2Op
import goober.free.appconfig.AppConfigOp
import goober.free.appintegrations.AppIntegrationsOp
import goober.free.appmesh.AppMeshOp
import goober.free.apprunner.AppRunnerOp
import goober.free.appstream.AppStreamOp
import goober.free.appsync.AppSyncOp
import goober.free.appflow.AppflowOp
import goober.free.applicationautoscaling.ApplicationAutoScalingOp
import goober.free.applicationcostprofiler.ApplicationCostProfilerOp
import goober.free.applicationdiscovery.ApplicationDiscoveryOp
import goober.free.applicationinsights.ApplicationInsightsOp
import goober.free.athena.AthenaOp
import goober.free.auditmanager.AuditManagerOp
import goober.free.autoscaling.AutoScalingOp
import goober.free.autoscalingplans.AutoScalingPlansOp
import goober.free.backup.BackupOp
import goober.free.batch.BatchOp
import goober.free.braket.BraketOp
import goober.free.budgets.BudgetsOp
import goober.free.chime.ChimeOp
import goober.free.cloud9.Cloud9Op
import goober.free.clouddirectory.CloudDirectoryOp
import goober.free.cloudformation.CloudFormationOp
import goober.free.cloudfront.CloudFrontOp
import goober.free.cloudhsm.CloudHsmOp
import goober.free.cloudhsmv2.CloudHsmV2Op
import goober.free.cloudsearch.CloudSearchOp
import goober.free.cloudsearchdomain.CloudSearchDomainOp
import goober.free.cloudtrail.CloudTrailOp
import goober.free.cloudwatch.CloudWatchOp
import goober.free.cloudwatchevents.CloudWatchEventsOp
import goober.free.cloudwatchlogs.CloudWatchLogsOp
import goober.free.codebuild.CodeBuildOp
import goober.free.codecommit.CodeCommitOp
import goober.free.codedeploy.CodeDeployOp
import goober.free.codeguruprofiler.CodeGuruProfilerOp
import goober.free.codegurureviewer.CodeGuruReviewerOp
import goober.free.codepipeline.CodePipelineOp
import goober.free.codestar.CodeStarOp
import goober.free.codestarconnections.CodeStarConnectionsOp
import goober.free.codeartifact.CodeartifactOp
import goober.free.codestarnotifications.CodestarNotificationsOp
import goober.free.cognitoidentity.CognitoIdentityOp
import goober.free.cognitoidentityprovider.CognitoIdentityProviderOp
import goober.free.cognitosync.CognitoSyncOp
import goober.free.comprehend.ComprehendOp
import goober.free.comprehendmedical.ComprehendMedicalOp
import goober.free.computeoptimizer.ComputeOptimizerOp
import goober.free.config.ConfigOp
import goober.free.connect.ConnectOp
import goober.free.connectcontactlens.ConnectContactLensOp
import goober.free.connectparticipant.ConnectParticipantOp
import goober.free.costandusagereport.CostAndUsageReportOp
import goober.free.costexplorer.CostExplorerOp
import goober.free.customerprofiles.CustomerProfilesOp
import goober.free.databrew.DataBrewOp
import goober.free.dataexchange.DataExchangeOp
import goober.free.datapipeline.DataPipelineOp
import goober.free.datasync.DataSyncOp
import goober.free.databasemigration.DatabaseMigrationOp
import goober.free.dax.DaxOp
import goober.free.detective.DetectiveOp
import goober.free.devopsguru.DevOpsGuruOp
import goober.free.devicefarm.DeviceFarmOp
import goober.free.directconnect.DirectConnectOp
import goober.free.directory.DirectoryOp
import goober.free.dlm.DlmOp
import goober.free.docdb.DocDbOp
import goober.free.dynamodb.DynamoDbOp
import goober.free.dynamodbstreams.DynamoDbStreamsOp
import goober.free.ebs.EbsOp
import goober.free.ec2.Ec2Op
import goober.free.ec2instanceconnect.Ec2InstanceConnectOp
import goober.free.ecr.EcrOp
import goober.free.ecrpublic.EcrPublicOp
import goober.free.ecs.EcsOp
import goober.free.efs.EfsOp
import goober.free.eks.EksOp
import goober.free.elasticache.ElastiCacheOp
import goober.free.elasticbeanstalk.ElasticBeanstalkOp
import goober.free.elasticinference.ElasticInferenceOp
import goober.free.elasticloadbalancing.ElasticLoadBalancingOp
import goober.free.elasticloadbalancingv2.ElasticLoadBalancingV2Op
import goober.free.elastictranscoder.ElasticTranscoderOp
import goober.free.elasticsearch.ElasticsearchOp
import goober.free.emr.EmrOp
import goober.free.emrcontainers.EmrContainersOp
import goober.free.eventbridge.EventBridgeOp
import goober.free.fsx.FSxOp
import goober.free.finspace.FinspaceOp
import goober.free.finspacedata.FinspaceDataOp
import goober.free.firehose.FirehoseOp
import goober.free.fis.FisOp
import goober.free.fms.FmsOp
import goober.free.forecast.ForecastOp
import goober.free.forecastquery.ForecastqueryOp
import goober.free.frauddetector.FraudDetectorOp
import goober.free.gamelift.GameLiftOp
import goober.free.glacier.GlacierOp
import goober.free.globalaccelerator.GlobalAcceleratorOp
import goober.free.glue.GlueOp
import goober.free.greengrass.GreengrassOp
import goober.free.greengrassv2.GreengrassV2Op
import goober.free.groundstation.GroundStationOp
import goober.free.guardduty.GuardDutyOp
import goober.free.health.HealthOp
import goober.free.healthlake.HealthLakeOp
import goober.free.honeycode.HoneycodeOp
import goober.free.iam.IamOp
import goober.free.identitystore.IdentitystoreOp
import goober.free.imagebuilder.ImagebuilderOp
import goober.free.inspector.InspectorOp
import goober.free.iotanalytics.IoTAnalyticsOp
import goober.free.iotfleethub.IoTFleetHubOp
import goober.free.iotsecuretunneling.IoTSecureTunnelingOp
import goober.free.iotsitewise.IoTSiteWiseOp
import goober.free.iotthingsgraph.IoTThingsGraphOp
import goober.free.iot.IotOp
import goober.free.iot1clickdevices.Iot1ClickDevicesOp
import goober.free.iot1clickprojects.Iot1ClickProjectsOp
import goober.free.iotdataplane.IotDataPlaneOp
import goober.free.iotdeviceadvisor.IotDeviceAdvisorOp
import goober.free.iotevents.IotEventsOp
import goober.free.ioteventsdata.IotEventsDataOp
import goober.free.iotjobsdataplane.IotJobsDataPlaneOp
import goober.free.iotwireless.IotWirelessOp
import goober.free.ivs.IvsOp
import goober.free.kafka.KafkaOp
import goober.free.kendra.KendraOp
import goober.free.kinesis.KinesisOp
import goober.free.kinesisanalytics.KinesisAnalyticsOp
import goober.free.kinesisanalyticsv2.KinesisAnalyticsV2Op
import goober.free.kinesisvideo.KinesisVideoOp
import goober.free.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaOp
import goober.free.kinesisvideomedia.KinesisVideoMediaOp
import goober.free.kinesisvideosignaling.KinesisVideoSignalingOp
import goober.free.kms.KmsOp
import goober.free.lakeformation.LakeFormationOp
import goober.free.lambda.LambdaOp
import goober.free.lexmodelbuilding.LexModelBuildingOp
import goober.free.lexmodelsv2.LexModelsV2Op
import goober.free.lexruntime.LexRuntimeOp
import goober.free.lexruntimev2.LexRuntimeV2Op
import goober.free.licensemanager.LicenseManagerOp
import goober.free.lightsail.LightsailOp
import goober.free.location.LocationOp
import goober.free.lookoutequipment.LookoutEquipmentOp
import goober.free.lookoutmetrics.LookoutMetricsOp
import goober.free.lookoutvision.LookoutVisionOp
import goober.free.mturk.MTurkOp
import goober.free.machinelearning.MachineLearningOp
import goober.free.macie.MacieOp
import goober.free.macie2.Macie2Op
import goober.free.managedblockchain.ManagedBlockchainOp
import goober.free.marketplacecatalog.MarketplaceCatalogOp
import goober.free.marketplacecommerceanalytics.MarketplaceCommerceAnalyticsOp
import goober.free.marketplaceentitlement.MarketplaceEntitlementOp
import goober.free.marketplacemetering.MarketplaceMeteringOp
import goober.free.mediaconnect.MediaConnectOp
import goober.free.mediaconvert.MediaConvertOp
import goober.free.medialive.MediaLiveOp
import goober.free.mediapackage.MediaPackageOp
import goober.free.mediapackagevod.MediaPackageVodOp
import goober.free.mediastore.MediaStoreOp
import goober.free.mediastoredata.MediaStoreDataOp
import goober.free.mediatailor.MediaTailorOp
import goober.free.mgn.MgnOp
import goober.free.migrationhub.MigrationHubOp
import goober.free.migrationhubconfig.MigrationHubConfigOp
import goober.free.mobile.MobileOp
import goober.free.mq.MqOp
import goober.free.mwaa.MwaaOp
import goober.free.neptune.NeptuneOp
import goober.free.networkfirewall.NetworkFirewallOp
import goober.free.networkmanager.NetworkManagerOp
import goober.free.nimble.NimbleOp
import goober.free.opsworks.OpsWorksOp
import goober.free.opsworkscm.OpsWorksCmOp
import goober.free.organizations.OrganizationsOp
import goober.free.outposts.OutpostsOp
import goober.free.personalize.PersonalizeOp
import goober.free.personalizeevents.PersonalizeEventsOp
import goober.free.personalizeruntime.PersonalizeRuntimeOp
import goober.free.pi.PiOp
import goober.free.pinpoint.PinpointOp
import goober.free.pinpointemail.PinpointEmailOp
import goober.free.pinpointsmsvoice.PinpointSmsVoiceOp
import goober.free.polly.PollyOp
import goober.free.pricing.PricingOp
import goober.free.proton.ProtonOp
import goober.free.qldb.QldbOp
import goober.free.qldbsession.QldbSessionOp
import goober.free.quicksight.QuickSightOp
import goober.free.ram.RamOp
import goober.free.rds.RdsOp
import goober.free.rdsdata.RdsDataOp
import goober.free.redshift.RedshiftOp
import goober.free.redshiftdata.RedshiftDataOp
import goober.free.rekognition.RekognitionOp
import goober.free.resourcegroups.ResourceGroupsOp
import goober.free.resourcegroupstaggingapi.ResourceGroupsTaggingApiOp
import goober.free.robomaker.RoboMakerOp
import goober.free.route53.Route53Op
import goober.free.route53domains.Route53DomainsOp
import goober.free.route53resolver.Route53ResolverOp
import goober.free.s3.S3Op
import goober.free.s3control.S3ControlOp
import goober.free.s3outposts.S3OutpostsOp
import goober.free.sagemaker.SageMakerOp
import goober.free.sagemakera2iruntime.SageMakerA2IRuntimeOp
import goober.free.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeOp
import goober.free.sagemakerruntime.SageMakerRuntimeOp
import goober.free.sagemakeredge.SagemakerEdgeOp
import goober.free.savingsplans.SavingsplansOp
import goober.free.schemas.SchemasOp
import goober.free.secretsmanager.SecretsManagerOp
import goober.free.securityhub.SecurityHubOp
import goober.free.serverlessapplicationrepository.ServerlessApplicationRepositoryOp
import goober.free.servicecatalog.ServiceCatalogOp
import goober.free.servicecatalogappregistry.ServiceCatalogAppRegistryOp
import goober.free.servicediscovery.ServiceDiscoveryOp
import goober.free.servicequotas.ServiceQuotasOp
import goober.free.ses.SesOp
import goober.free.sesv2.SesV2Op
import goober.free.sfn.SfnOp
import goober.free.shield.ShieldOp
import goober.free.signer.SignerOp
import goober.free.sms.SmsOp
import goober.free.snowball.SnowballOp
import goober.free.sns.SnsOp
import goober.free.sqs.SqsOp
import goober.free.ssm.SsmOp
import goober.free.ssmcontacts.SsmContactsOp
import goober.free.ssmincidents.SsmIncidentsOp
import goober.free.sso.SsoOp
import goober.free.ssoadmin.SsoAdminOp
import goober.free.ssooidc.SsoOidcOp
import goober.free.storagegateway.StorageGatewayOp
import goober.free.sts.StsOp
import goober.free.support.SupportOp
import goober.free.swf.SwfOp
import goober.free.synthetics.SyntheticsOp
import goober.free.textract.TextractOp
import goober.free.timestreamquery.TimestreamQueryOp
import goober.free.timestreamwrite.TimestreamWriteOp
import goober.free.transcribe.TranscribeOp
import goober.free.transfer.TransferOp
import goober.free.translate.TranslateOp
import goober.free.waf.WafOp
import goober.free.wafregional.WafRegionalOp
import goober.free.wafv2.Wafv2Op
import goober.free.wellarchitected.WellArchitectedOp
import goober.free.workdocs.WorkDocsOp
import goober.free.worklink.WorkLinkOp
import goober.free.workmail.WorkMailOp
import goober.free.workmailmessageflow.WorkMailMessageFlowOp
import goober.free.workspaces.WorkSpacesOp
import goober.free.xray.XRayOp
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
import software.amazon.awssdk.services.appintegrations.AppIntegrationsClient
import software.amazon.awssdk.services.appmesh.AppMeshClient
import software.amazon.awssdk.services.apprunner.AppRunnerClient
import software.amazon.awssdk.services.appstream.AppStreamClient
import software.amazon.awssdk.services.appsync.AppSyncClient
import software.amazon.awssdk.services.appflow.AppflowClient
import software.amazon.awssdk.services.applicationautoscaling.ApplicationAutoScalingClient
import software.amazon.awssdk.services.applicationcostprofiler.ApplicationCostProfilerClient
import software.amazon.awssdk.services.applicationdiscovery.ApplicationDiscoveryClient
import software.amazon.awssdk.services.applicationinsights.ApplicationInsightsClient
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
import software.amazon.awssdk.services.codebuild.CodeBuildClient
import software.amazon.awssdk.services.codecommit.CodeCommitClient
import software.amazon.awssdk.services.codedeploy.CodeDeployClient
import software.amazon.awssdk.services.codeguruprofiler.CodeGuruProfilerClient
import software.amazon.awssdk.services.codegurureviewer.CodeGuruReviewerClient
import software.amazon.awssdk.services.codepipeline.CodePipelineClient
import software.amazon.awssdk.services.codestar.CodeStarClient
import software.amazon.awssdk.services.codestarconnections.CodeStarConnectionsClient
import software.amazon.awssdk.services.codeartifact.CodeartifactClient
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
import software.amazon.awssdk.services.databrew.DataBrewClient
import software.amazon.awssdk.services.dataexchange.DataExchangeClient
import software.amazon.awssdk.services.datapipeline.DataPipelineClient
import software.amazon.awssdk.services.datasync.DataSyncClient
import software.amazon.awssdk.services.databasemigration.DatabaseMigrationClient
import software.amazon.awssdk.services.dax.DaxClient
import software.amazon.awssdk.services.detective.DetectiveClient
import software.amazon.awssdk.services.devopsguru.DevOpsGuruClient
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient
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
import software.amazon.awssdk.services.elastictranscoder.ElasticTranscoderClient
import software.amazon.awssdk.services.elasticsearch.ElasticsearchClient
import software.amazon.awssdk.services.emr.EmrClient
import software.amazon.awssdk.services.emrcontainers.EmrContainersClient
import software.amazon.awssdk.services.eventbridge.EventBridgeClient
import software.amazon.awssdk.services.fsx.FSxClient
import software.amazon.awssdk.services.finspace.FinspaceClient
import software.amazon.awssdk.services.finspacedata.FinspaceDataClient
import software.amazon.awssdk.services.firehose.FirehoseClient
import software.amazon.awssdk.services.fis.FisClient
import software.amazon.awssdk.services.fms.FmsClient
import software.amazon.awssdk.services.forecast.ForecastClient
import software.amazon.awssdk.services.forecastquery.ForecastqueryClient
import software.amazon.awssdk.services.frauddetector.FraudDetectorClient
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
import software.amazon.awssdk.services.iotanalytics.IoTAnalyticsClient
import software.amazon.awssdk.services.iotfleethub.IoTFleetHubClient
import software.amazon.awssdk.services.iotsecuretunneling.IoTSecureTunnelingClient
import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient
import software.amazon.awssdk.services.iotthingsgraph.IoTThingsGraphClient
import software.amazon.awssdk.services.iot.IotClient
import software.amazon.awssdk.services.iot1clickdevices.Iot1ClickDevicesClient
import software.amazon.awssdk.services.iot1clickprojects.Iot1ClickProjectsClient
import software.amazon.awssdk.services.iotdataplane.IotDataPlaneClient
import software.amazon.awssdk.services.iotdeviceadvisor.IotDeviceAdvisorClient
import software.amazon.awssdk.services.iotevents.IotEventsClient
import software.amazon.awssdk.services.ioteventsdata.IotEventsDataClient
import software.amazon.awssdk.services.iotjobsdataplane.IotJobsDataPlaneClient
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
import software.amazon.awssdk.services.mturk.MTurkClient
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
import software.amazon.awssdk.services.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeClient
import software.amazon.awssdk.services.sagemakerruntime.SageMakerRuntimeClient
import software.amazon.awssdk.services.sagemakeredge.SagemakerEdgeClient
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


object KleisliInterpreter {
  def apply[M[_]](b: Blocker)(implicit
    am: Async[M],
    cs: ContextShift[M]
  ): KleisliInterpreter[M] = new KleisliInterpreter[M] {
    val asyncM = am
    val contextShiftM = cs
    val blocker = b
  }
}

trait KleisliInterpreter[M[_]] { interpreter =>
  lazy val AccessAnalyzerInterpreter: AccessAnalyzerOp ~> Kleisli[M, AccessAnalyzerClient, *] = new AccessAnalyzerInterpreter {
    def primitive[A](f: AccessAnalyzerClient ⇒ A): Kleisli[M, AccessAnalyzerClient, A] = interpreter.primitive(f)
  }

  lazy val AcmInterpreter: AcmOp ~> Kleisli[M, AcmClient, *] = new AcmInterpreter {
    def primitive[A](f: AcmClient ⇒ A): Kleisli[M, AcmClient, A] = interpreter.primitive(f)
  }

  lazy val AcmPcaInterpreter: AcmPcaOp ~> Kleisli[M, AcmPcaClient, *] = new AcmPcaInterpreter {
    def primitive[A](f: AcmPcaClient ⇒ A): Kleisli[M, AcmPcaClient, A] = interpreter.primitive(f)
  }

  lazy val AlexaForBusinessInterpreter: AlexaForBusinessOp ~> Kleisli[M, AlexaForBusinessClient, *] = new AlexaForBusinessInterpreter {
    def primitive[A](f: AlexaForBusinessClient ⇒ A): Kleisli[M, AlexaForBusinessClient, A] = interpreter.primitive(f)
  }

  lazy val AmpInterpreter: AmpOp ~> Kleisli[M, AmpClient, *] = new AmpInterpreter {
    def primitive[A](f: AmpClient ⇒ A): Kleisli[M, AmpClient, A] = interpreter.primitive(f)
  }

  lazy val AmplifyInterpreter: AmplifyOp ~> Kleisli[M, AmplifyClient, *] = new AmplifyInterpreter {
    def primitive[A](f: AmplifyClient ⇒ A): Kleisli[M, AmplifyClient, A] = interpreter.primitive(f)
  }

  lazy val AmplifyBackendInterpreter: AmplifyBackendOp ~> Kleisli[M, AmplifyBackendClient, *] = new AmplifyBackendInterpreter {
    def primitive[A](f: AmplifyBackendClient ⇒ A): Kleisli[M, AmplifyBackendClient, A] = interpreter.primitive(f)
  }

  lazy val ApiGatewayInterpreter: ApiGatewayOp ~> Kleisli[M, ApiGatewayClient, *] = new ApiGatewayInterpreter {
    def primitive[A](f: ApiGatewayClient ⇒ A): Kleisli[M, ApiGatewayClient, A] = interpreter.primitive(f)
  }

  lazy val ApiGatewayManagementApiInterpreter: ApiGatewayManagementApiOp ~> Kleisli[M, ApiGatewayManagementApiClient, *] = new ApiGatewayManagementApiInterpreter {
    def primitive[A](f: ApiGatewayManagementApiClient ⇒ A): Kleisli[M, ApiGatewayManagementApiClient, A] = interpreter.primitive(f)
  }

  lazy val ApiGatewayV2Interpreter: ApiGatewayV2Op ~> Kleisli[M, ApiGatewayV2Client, *] = new ApiGatewayV2Interpreter {
    def primitive[A](f: ApiGatewayV2Client ⇒ A): Kleisli[M, ApiGatewayV2Client, A] = interpreter.primitive(f)
  }

  lazy val AppConfigInterpreter: AppConfigOp ~> Kleisli[M, AppConfigClient, *] = new AppConfigInterpreter {
    def primitive[A](f: AppConfigClient ⇒ A): Kleisli[M, AppConfigClient, A] = interpreter.primitive(f)
  }

  lazy val AppIntegrationsInterpreter: AppIntegrationsOp ~> Kleisli[M, AppIntegrationsClient, *] = new AppIntegrationsInterpreter {
    def primitive[A](f: AppIntegrationsClient ⇒ A): Kleisli[M, AppIntegrationsClient, A] = interpreter.primitive(f)
  }

  lazy val AppMeshInterpreter: AppMeshOp ~> Kleisli[M, AppMeshClient, *] = new AppMeshInterpreter {
    def primitive[A](f: AppMeshClient ⇒ A): Kleisli[M, AppMeshClient, A] = interpreter.primitive(f)
  }

  lazy val AppRunnerInterpreter: AppRunnerOp ~> Kleisli[M, AppRunnerClient, *] = new AppRunnerInterpreter {
    def primitive[A](f: AppRunnerClient ⇒ A): Kleisli[M, AppRunnerClient, A] = interpreter.primitive(f)
  }

  lazy val AppStreamInterpreter: AppStreamOp ~> Kleisli[M, AppStreamClient, *] = new AppStreamInterpreter {
    def primitive[A](f: AppStreamClient ⇒ A): Kleisli[M, AppStreamClient, A] = interpreter.primitive(f)
  }

  lazy val AppSyncInterpreter: AppSyncOp ~> Kleisli[M, AppSyncClient, *] = new AppSyncInterpreter {
    def primitive[A](f: AppSyncClient ⇒ A): Kleisli[M, AppSyncClient, A] = interpreter.primitive(f)
  }

  lazy val AppflowInterpreter: AppflowOp ~> Kleisli[M, AppflowClient, *] = new AppflowInterpreter {
    def primitive[A](f: AppflowClient ⇒ A): Kleisli[M, AppflowClient, A] = interpreter.primitive(f)
  }

  lazy val ApplicationAutoScalingInterpreter: ApplicationAutoScalingOp ~> Kleisli[M, ApplicationAutoScalingClient, *] = new ApplicationAutoScalingInterpreter {
    def primitive[A](f: ApplicationAutoScalingClient ⇒ A): Kleisli[M, ApplicationAutoScalingClient, A] = interpreter.primitive(f)
  }

  lazy val ApplicationCostProfilerInterpreter: ApplicationCostProfilerOp ~> Kleisli[M, ApplicationCostProfilerClient, *] = new ApplicationCostProfilerInterpreter {
    def primitive[A](f: ApplicationCostProfilerClient ⇒ A): Kleisli[M, ApplicationCostProfilerClient, A] = interpreter.primitive(f)
  }

  lazy val ApplicationDiscoveryInterpreter: ApplicationDiscoveryOp ~> Kleisli[M, ApplicationDiscoveryClient, *] = new ApplicationDiscoveryInterpreter {
    def primitive[A](f: ApplicationDiscoveryClient ⇒ A): Kleisli[M, ApplicationDiscoveryClient, A] = interpreter.primitive(f)
  }

  lazy val ApplicationInsightsInterpreter: ApplicationInsightsOp ~> Kleisli[M, ApplicationInsightsClient, *] = new ApplicationInsightsInterpreter {
    def primitive[A](f: ApplicationInsightsClient ⇒ A): Kleisli[M, ApplicationInsightsClient, A] = interpreter.primitive(f)
  }

  lazy val AthenaInterpreter: AthenaOp ~> Kleisli[M, AthenaClient, *] = new AthenaInterpreter {
    def primitive[A](f: AthenaClient ⇒ A): Kleisli[M, AthenaClient, A] = interpreter.primitive(f)
  }

  lazy val AuditManagerInterpreter: AuditManagerOp ~> Kleisli[M, AuditManagerClient, *] = new AuditManagerInterpreter {
    def primitive[A](f: AuditManagerClient ⇒ A): Kleisli[M, AuditManagerClient, A] = interpreter.primitive(f)
  }

  lazy val AutoScalingInterpreter: AutoScalingOp ~> Kleisli[M, AutoScalingClient, *] = new AutoScalingInterpreter {
    def primitive[A](f: AutoScalingClient ⇒ A): Kleisli[M, AutoScalingClient, A] = interpreter.primitive(f)
  }

  lazy val AutoScalingPlansInterpreter: AutoScalingPlansOp ~> Kleisli[M, AutoScalingPlansClient, *] = new AutoScalingPlansInterpreter {
    def primitive[A](f: AutoScalingPlansClient ⇒ A): Kleisli[M, AutoScalingPlansClient, A] = interpreter.primitive(f)
  }

  lazy val BackupInterpreter: BackupOp ~> Kleisli[M, BackupClient, *] = new BackupInterpreter {
    def primitive[A](f: BackupClient ⇒ A): Kleisli[M, BackupClient, A] = interpreter.primitive(f)
  }

  lazy val BatchInterpreter: BatchOp ~> Kleisli[M, BatchClient, *] = new BatchInterpreter {
    def primitive[A](f: BatchClient ⇒ A): Kleisli[M, BatchClient, A] = interpreter.primitive(f)
  }

  lazy val BraketInterpreter: BraketOp ~> Kleisli[M, BraketClient, *] = new BraketInterpreter {
    def primitive[A](f: BraketClient ⇒ A): Kleisli[M, BraketClient, A] = interpreter.primitive(f)
  }

  lazy val BudgetsInterpreter: BudgetsOp ~> Kleisli[M, BudgetsClient, *] = new BudgetsInterpreter {
    def primitive[A](f: BudgetsClient ⇒ A): Kleisli[M, BudgetsClient, A] = interpreter.primitive(f)
  }

  lazy val ChimeInterpreter: ChimeOp ~> Kleisli[M, ChimeClient, *] = new ChimeInterpreter {
    def primitive[A](f: ChimeClient ⇒ A): Kleisli[M, ChimeClient, A] = interpreter.primitive(f)
  }

  lazy val Cloud9Interpreter: Cloud9Op ~> Kleisli[M, Cloud9Client, *] = new Cloud9Interpreter {
    def primitive[A](f: Cloud9Client ⇒ A): Kleisli[M, Cloud9Client, A] = interpreter.primitive(f)
  }

  lazy val CloudDirectoryInterpreter: CloudDirectoryOp ~> Kleisli[M, CloudDirectoryClient, *] = new CloudDirectoryInterpreter {
    def primitive[A](f: CloudDirectoryClient ⇒ A): Kleisli[M, CloudDirectoryClient, A] = interpreter.primitive(f)
  }

  lazy val CloudFormationInterpreter: CloudFormationOp ~> Kleisli[M, CloudFormationClient, *] = new CloudFormationInterpreter {
    def primitive[A](f: CloudFormationClient ⇒ A): Kleisli[M, CloudFormationClient, A] = interpreter.primitive(f)
  }

  lazy val CloudFrontInterpreter: CloudFrontOp ~> Kleisli[M, CloudFrontClient, *] = new CloudFrontInterpreter {
    def primitive[A](f: CloudFrontClient ⇒ A): Kleisli[M, CloudFrontClient, A] = interpreter.primitive(f)
  }

  lazy val CloudHsmInterpreter: CloudHsmOp ~> Kleisli[M, CloudHsmClient, *] = new CloudHsmInterpreter {
    def primitive[A](f: CloudHsmClient ⇒ A): Kleisli[M, CloudHsmClient, A] = interpreter.primitive(f)
  }

  lazy val CloudHsmV2Interpreter: CloudHsmV2Op ~> Kleisli[M, CloudHsmV2Client, *] = new CloudHsmV2Interpreter {
    def primitive[A](f: CloudHsmV2Client ⇒ A): Kleisli[M, CloudHsmV2Client, A] = interpreter.primitive(f)
  }

  lazy val CloudSearchInterpreter: CloudSearchOp ~> Kleisli[M, CloudSearchClient, *] = new CloudSearchInterpreter {
    def primitive[A](f: CloudSearchClient ⇒ A): Kleisli[M, CloudSearchClient, A] = interpreter.primitive(f)
  }

  lazy val CloudSearchDomainInterpreter: CloudSearchDomainOp ~> Kleisli[M, CloudSearchDomainClient, *] = new CloudSearchDomainInterpreter {
    def primitive[A](f: CloudSearchDomainClient ⇒ A): Kleisli[M, CloudSearchDomainClient, A] = interpreter.primitive(f)
  }

  lazy val CloudTrailInterpreter: CloudTrailOp ~> Kleisli[M, CloudTrailClient, *] = new CloudTrailInterpreter {
    def primitive[A](f: CloudTrailClient ⇒ A): Kleisli[M, CloudTrailClient, A] = interpreter.primitive(f)
  }

  lazy val CloudWatchInterpreter: CloudWatchOp ~> Kleisli[M, CloudWatchClient, *] = new CloudWatchInterpreter {
    def primitive[A](f: CloudWatchClient ⇒ A): Kleisli[M, CloudWatchClient, A] = interpreter.primitive(f)
  }

  lazy val CloudWatchEventsInterpreter: CloudWatchEventsOp ~> Kleisli[M, CloudWatchEventsClient, *] = new CloudWatchEventsInterpreter {
    def primitive[A](f: CloudWatchEventsClient ⇒ A): Kleisli[M, CloudWatchEventsClient, A] = interpreter.primitive(f)
  }

  lazy val CloudWatchLogsInterpreter: CloudWatchLogsOp ~> Kleisli[M, CloudWatchLogsClient, *] = new CloudWatchLogsInterpreter {
    def primitive[A](f: CloudWatchLogsClient ⇒ A): Kleisli[M, CloudWatchLogsClient, A] = interpreter.primitive(f)
  }

  lazy val CodeBuildInterpreter: CodeBuildOp ~> Kleisli[M, CodeBuildClient, *] = new CodeBuildInterpreter {
    def primitive[A](f: CodeBuildClient ⇒ A): Kleisli[M, CodeBuildClient, A] = interpreter.primitive(f)
  }

  lazy val CodeCommitInterpreter: CodeCommitOp ~> Kleisli[M, CodeCommitClient, *] = new CodeCommitInterpreter {
    def primitive[A](f: CodeCommitClient ⇒ A): Kleisli[M, CodeCommitClient, A] = interpreter.primitive(f)
  }

  lazy val CodeDeployInterpreter: CodeDeployOp ~> Kleisli[M, CodeDeployClient, *] = new CodeDeployInterpreter {
    def primitive[A](f: CodeDeployClient ⇒ A): Kleisli[M, CodeDeployClient, A] = interpreter.primitive(f)
  }

  lazy val CodeGuruProfilerInterpreter: CodeGuruProfilerOp ~> Kleisli[M, CodeGuruProfilerClient, *] = new CodeGuruProfilerInterpreter {
    def primitive[A](f: CodeGuruProfilerClient ⇒ A): Kleisli[M, CodeGuruProfilerClient, A] = interpreter.primitive(f)
  }

  lazy val CodeGuruReviewerInterpreter: CodeGuruReviewerOp ~> Kleisli[M, CodeGuruReviewerClient, *] = new CodeGuruReviewerInterpreter {
    def primitive[A](f: CodeGuruReviewerClient ⇒ A): Kleisli[M, CodeGuruReviewerClient, A] = interpreter.primitive(f)
  }

  lazy val CodePipelineInterpreter: CodePipelineOp ~> Kleisli[M, CodePipelineClient, *] = new CodePipelineInterpreter {
    def primitive[A](f: CodePipelineClient ⇒ A): Kleisli[M, CodePipelineClient, A] = interpreter.primitive(f)
  }

  lazy val CodeStarInterpreter: CodeStarOp ~> Kleisli[M, CodeStarClient, *] = new CodeStarInterpreter {
    def primitive[A](f: CodeStarClient ⇒ A): Kleisli[M, CodeStarClient, A] = interpreter.primitive(f)
  }

  lazy val CodeStarConnectionsInterpreter: CodeStarConnectionsOp ~> Kleisli[M, CodeStarConnectionsClient, *] = new CodeStarConnectionsInterpreter {
    def primitive[A](f: CodeStarConnectionsClient ⇒ A): Kleisli[M, CodeStarConnectionsClient, A] = interpreter.primitive(f)
  }

  lazy val CodeartifactInterpreter: CodeartifactOp ~> Kleisli[M, CodeartifactClient, *] = new CodeartifactInterpreter {
    def primitive[A](f: CodeartifactClient ⇒ A): Kleisli[M, CodeartifactClient, A] = interpreter.primitive(f)
  }

  lazy val CodestarNotificationsInterpreter: CodestarNotificationsOp ~> Kleisli[M, CodestarNotificationsClient, *] = new CodestarNotificationsInterpreter {
    def primitive[A](f: CodestarNotificationsClient ⇒ A): Kleisli[M, CodestarNotificationsClient, A] = interpreter.primitive(f)
  }

  lazy val CognitoIdentityInterpreter: CognitoIdentityOp ~> Kleisli[M, CognitoIdentityClient, *] = new CognitoIdentityInterpreter {
    def primitive[A](f: CognitoIdentityClient ⇒ A): Kleisli[M, CognitoIdentityClient, A] = interpreter.primitive(f)
  }

  lazy val CognitoIdentityProviderInterpreter: CognitoIdentityProviderOp ~> Kleisli[M, CognitoIdentityProviderClient, *] = new CognitoIdentityProviderInterpreter {
    def primitive[A](f: CognitoIdentityProviderClient ⇒ A): Kleisli[M, CognitoIdentityProviderClient, A] = interpreter.primitive(f)
  }

  lazy val CognitoSyncInterpreter: CognitoSyncOp ~> Kleisli[M, CognitoSyncClient, *] = new CognitoSyncInterpreter {
    def primitive[A](f: CognitoSyncClient ⇒ A): Kleisli[M, CognitoSyncClient, A] = interpreter.primitive(f)
  }

  lazy val ComprehendInterpreter: ComprehendOp ~> Kleisli[M, ComprehendClient, *] = new ComprehendInterpreter {
    def primitive[A](f: ComprehendClient ⇒ A): Kleisli[M, ComprehendClient, A] = interpreter.primitive(f)
  }

  lazy val ComprehendMedicalInterpreter: ComprehendMedicalOp ~> Kleisli[M, ComprehendMedicalClient, *] = new ComprehendMedicalInterpreter {
    def primitive[A](f: ComprehendMedicalClient ⇒ A): Kleisli[M, ComprehendMedicalClient, A] = interpreter.primitive(f)
  }

  lazy val ComputeOptimizerInterpreter: ComputeOptimizerOp ~> Kleisli[M, ComputeOptimizerClient, *] = new ComputeOptimizerInterpreter {
    def primitive[A](f: ComputeOptimizerClient ⇒ A): Kleisli[M, ComputeOptimizerClient, A] = interpreter.primitive(f)
  }

  lazy val ConfigInterpreter: ConfigOp ~> Kleisli[M, ConfigClient, *] = new ConfigInterpreter {
    def primitive[A](f: ConfigClient ⇒ A): Kleisli[M, ConfigClient, A] = interpreter.primitive(f)
  }

  lazy val ConnectInterpreter: ConnectOp ~> Kleisli[M, ConnectClient, *] = new ConnectInterpreter {
    def primitive[A](f: ConnectClient ⇒ A): Kleisli[M, ConnectClient, A] = interpreter.primitive(f)
  }

  lazy val ConnectContactLensInterpreter: ConnectContactLensOp ~> Kleisli[M, ConnectContactLensClient, *] = new ConnectContactLensInterpreter {
    def primitive[A](f: ConnectContactLensClient ⇒ A): Kleisli[M, ConnectContactLensClient, A] = interpreter.primitive(f)
  }

  lazy val ConnectParticipantInterpreter: ConnectParticipantOp ~> Kleisli[M, ConnectParticipantClient, *] = new ConnectParticipantInterpreter {
    def primitive[A](f: ConnectParticipantClient ⇒ A): Kleisli[M, ConnectParticipantClient, A] = interpreter.primitive(f)
  }

  lazy val CostAndUsageReportInterpreter: CostAndUsageReportOp ~> Kleisli[M, CostAndUsageReportClient, *] = new CostAndUsageReportInterpreter {
    def primitive[A](f: CostAndUsageReportClient ⇒ A): Kleisli[M, CostAndUsageReportClient, A] = interpreter.primitive(f)
  }

  lazy val CostExplorerInterpreter: CostExplorerOp ~> Kleisli[M, CostExplorerClient, *] = new CostExplorerInterpreter {
    def primitive[A](f: CostExplorerClient ⇒ A): Kleisli[M, CostExplorerClient, A] = interpreter.primitive(f)
  }

  lazy val CustomerProfilesInterpreter: CustomerProfilesOp ~> Kleisli[M, CustomerProfilesClient, *] = new CustomerProfilesInterpreter {
    def primitive[A](f: CustomerProfilesClient ⇒ A): Kleisli[M, CustomerProfilesClient, A] = interpreter.primitive(f)
  }

  lazy val DataBrewInterpreter: DataBrewOp ~> Kleisli[M, DataBrewClient, *] = new DataBrewInterpreter {
    def primitive[A](f: DataBrewClient ⇒ A): Kleisli[M, DataBrewClient, A] = interpreter.primitive(f)
  }

  lazy val DataExchangeInterpreter: DataExchangeOp ~> Kleisli[M, DataExchangeClient, *] = new DataExchangeInterpreter {
    def primitive[A](f: DataExchangeClient ⇒ A): Kleisli[M, DataExchangeClient, A] = interpreter.primitive(f)
  }

  lazy val DataPipelineInterpreter: DataPipelineOp ~> Kleisli[M, DataPipelineClient, *] = new DataPipelineInterpreter {
    def primitive[A](f: DataPipelineClient ⇒ A): Kleisli[M, DataPipelineClient, A] = interpreter.primitive(f)
  }

  lazy val DataSyncInterpreter: DataSyncOp ~> Kleisli[M, DataSyncClient, *] = new DataSyncInterpreter {
    def primitive[A](f: DataSyncClient ⇒ A): Kleisli[M, DataSyncClient, A] = interpreter.primitive(f)
  }

  lazy val DatabaseMigrationInterpreter: DatabaseMigrationOp ~> Kleisli[M, DatabaseMigrationClient, *] = new DatabaseMigrationInterpreter {
    def primitive[A](f: DatabaseMigrationClient ⇒ A): Kleisli[M, DatabaseMigrationClient, A] = interpreter.primitive(f)
  }

  lazy val DaxInterpreter: DaxOp ~> Kleisli[M, DaxClient, *] = new DaxInterpreter {
    def primitive[A](f: DaxClient ⇒ A): Kleisli[M, DaxClient, A] = interpreter.primitive(f)
  }

  lazy val DetectiveInterpreter: DetectiveOp ~> Kleisli[M, DetectiveClient, *] = new DetectiveInterpreter {
    def primitive[A](f: DetectiveClient ⇒ A): Kleisli[M, DetectiveClient, A] = interpreter.primitive(f)
  }

  lazy val DevOpsGuruInterpreter: DevOpsGuruOp ~> Kleisli[M, DevOpsGuruClient, *] = new DevOpsGuruInterpreter {
    def primitive[A](f: DevOpsGuruClient ⇒ A): Kleisli[M, DevOpsGuruClient, A] = interpreter.primitive(f)
  }

  lazy val DeviceFarmInterpreter: DeviceFarmOp ~> Kleisli[M, DeviceFarmClient, *] = new DeviceFarmInterpreter {
    def primitive[A](f: DeviceFarmClient ⇒ A): Kleisli[M, DeviceFarmClient, A] = interpreter.primitive(f)
  }

  lazy val DirectConnectInterpreter: DirectConnectOp ~> Kleisli[M, DirectConnectClient, *] = new DirectConnectInterpreter {
    def primitive[A](f: DirectConnectClient ⇒ A): Kleisli[M, DirectConnectClient, A] = interpreter.primitive(f)
  }

  lazy val DirectoryInterpreter: DirectoryOp ~> Kleisli[M, DirectoryClient, *] = new DirectoryInterpreter {
    def primitive[A](f: DirectoryClient ⇒ A): Kleisli[M, DirectoryClient, A] = interpreter.primitive(f)
  }

  lazy val DlmInterpreter: DlmOp ~> Kleisli[M, DlmClient, *] = new DlmInterpreter {
    def primitive[A](f: DlmClient ⇒ A): Kleisli[M, DlmClient, A] = interpreter.primitive(f)
  }

  lazy val DocDbInterpreter: DocDbOp ~> Kleisli[M, DocDbClient, *] = new DocDbInterpreter {
    def primitive[A](f: DocDbClient ⇒ A): Kleisli[M, DocDbClient, A] = interpreter.primitive(f)
  }

  lazy val DynamoDbInterpreter: DynamoDbOp ~> Kleisli[M, DynamoDbClient, *] = new DynamoDbInterpreter {
    def primitive[A](f: DynamoDbClient ⇒ A): Kleisli[M, DynamoDbClient, A] = interpreter.primitive(f)
  }

  lazy val DynamoDbStreamsInterpreter: DynamoDbStreamsOp ~> Kleisli[M, DynamoDbStreamsClient, *] = new DynamoDbStreamsInterpreter {
    def primitive[A](f: DynamoDbStreamsClient ⇒ A): Kleisli[M, DynamoDbStreamsClient, A] = interpreter.primitive(f)
  }

  lazy val EbsInterpreter: EbsOp ~> Kleisli[M, EbsClient, *] = new EbsInterpreter {
    def primitive[A](f: EbsClient ⇒ A): Kleisli[M, EbsClient, A] = interpreter.primitive(f)
  }

  lazy val Ec2Interpreter: Ec2Op ~> Kleisli[M, Ec2Client, *] = new Ec2Interpreter {
    def primitive[A](f: Ec2Client ⇒ A): Kleisli[M, Ec2Client, A] = interpreter.primitive(f)
  }

  lazy val Ec2InstanceConnectInterpreter: Ec2InstanceConnectOp ~> Kleisli[M, Ec2InstanceConnectClient, *] = new Ec2InstanceConnectInterpreter {
    def primitive[A](f: Ec2InstanceConnectClient ⇒ A): Kleisli[M, Ec2InstanceConnectClient, A] = interpreter.primitive(f)
  }

  lazy val EcrInterpreter: EcrOp ~> Kleisli[M, EcrClient, *] = new EcrInterpreter {
    def primitive[A](f: EcrClient ⇒ A): Kleisli[M, EcrClient, A] = interpreter.primitive(f)
  }

  lazy val EcrPublicInterpreter: EcrPublicOp ~> Kleisli[M, EcrPublicClient, *] = new EcrPublicInterpreter {
    def primitive[A](f: EcrPublicClient ⇒ A): Kleisli[M, EcrPublicClient, A] = interpreter.primitive(f)
  }

  lazy val EcsInterpreter: EcsOp ~> Kleisli[M, EcsClient, *] = new EcsInterpreter {
    def primitive[A](f: EcsClient ⇒ A): Kleisli[M, EcsClient, A] = interpreter.primitive(f)
  }

  lazy val EfsInterpreter: EfsOp ~> Kleisli[M, EfsClient, *] = new EfsInterpreter {
    def primitive[A](f: EfsClient ⇒ A): Kleisli[M, EfsClient, A] = interpreter.primitive(f)
  }

  lazy val EksInterpreter: EksOp ~> Kleisli[M, EksClient, *] = new EksInterpreter {
    def primitive[A](f: EksClient ⇒ A): Kleisli[M, EksClient, A] = interpreter.primitive(f)
  }

  lazy val ElastiCacheInterpreter: ElastiCacheOp ~> Kleisli[M, ElastiCacheClient, *] = new ElastiCacheInterpreter {
    def primitive[A](f: ElastiCacheClient ⇒ A): Kleisli[M, ElastiCacheClient, A] = interpreter.primitive(f)
  }

  lazy val ElasticBeanstalkInterpreter: ElasticBeanstalkOp ~> Kleisli[M, ElasticBeanstalkClient, *] = new ElasticBeanstalkInterpreter {
    def primitive[A](f: ElasticBeanstalkClient ⇒ A): Kleisli[M, ElasticBeanstalkClient, A] = interpreter.primitive(f)
  }

  lazy val ElasticInferenceInterpreter: ElasticInferenceOp ~> Kleisli[M, ElasticInferenceClient, *] = new ElasticInferenceInterpreter {
    def primitive[A](f: ElasticInferenceClient ⇒ A): Kleisli[M, ElasticInferenceClient, A] = interpreter.primitive(f)
  }

  lazy val ElasticLoadBalancingInterpreter: ElasticLoadBalancingOp ~> Kleisli[M, ElasticLoadBalancingClient, *] = new ElasticLoadBalancingInterpreter {
    def primitive[A](f: ElasticLoadBalancingClient ⇒ A): Kleisli[M, ElasticLoadBalancingClient, A] = interpreter.primitive(f)
  }

  lazy val ElasticLoadBalancingV2Interpreter: ElasticLoadBalancingV2Op ~> Kleisli[M, ElasticLoadBalancingV2Client, *] = new ElasticLoadBalancingV2Interpreter {
    def primitive[A](f: ElasticLoadBalancingV2Client ⇒ A): Kleisli[M, ElasticLoadBalancingV2Client, A] = interpreter.primitive(f)
  }

  lazy val ElasticTranscoderInterpreter: ElasticTranscoderOp ~> Kleisli[M, ElasticTranscoderClient, *] = new ElasticTranscoderInterpreter {
    def primitive[A](f: ElasticTranscoderClient ⇒ A): Kleisli[M, ElasticTranscoderClient, A] = interpreter.primitive(f)
  }

  lazy val ElasticsearchInterpreter: ElasticsearchOp ~> Kleisli[M, ElasticsearchClient, *] = new ElasticsearchInterpreter {
    def primitive[A](f: ElasticsearchClient ⇒ A): Kleisli[M, ElasticsearchClient, A] = interpreter.primitive(f)
  }

  lazy val EmrInterpreter: EmrOp ~> Kleisli[M, EmrClient, *] = new EmrInterpreter {
    def primitive[A](f: EmrClient ⇒ A): Kleisli[M, EmrClient, A] = interpreter.primitive(f)
  }

  lazy val EmrContainersInterpreter: EmrContainersOp ~> Kleisli[M, EmrContainersClient, *] = new EmrContainersInterpreter {
    def primitive[A](f: EmrContainersClient ⇒ A): Kleisli[M, EmrContainersClient, A] = interpreter.primitive(f)
  }

  lazy val EventBridgeInterpreter: EventBridgeOp ~> Kleisli[M, EventBridgeClient, *] = new EventBridgeInterpreter {
    def primitive[A](f: EventBridgeClient ⇒ A): Kleisli[M, EventBridgeClient, A] = interpreter.primitive(f)
  }

  lazy val FSxInterpreter: FSxOp ~> Kleisli[M, FSxClient, *] = new FSxInterpreter {
    def primitive[A](f: FSxClient ⇒ A): Kleisli[M, FSxClient, A] = interpreter.primitive(f)
  }

  lazy val FinspaceInterpreter: FinspaceOp ~> Kleisli[M, FinspaceClient, *] = new FinspaceInterpreter {
    def primitive[A](f: FinspaceClient ⇒ A): Kleisli[M, FinspaceClient, A] = interpreter.primitive(f)
  }

  lazy val FinspaceDataInterpreter: FinspaceDataOp ~> Kleisli[M, FinspaceDataClient, *] = new FinspaceDataInterpreter {
    def primitive[A](f: FinspaceDataClient ⇒ A): Kleisli[M, FinspaceDataClient, A] = interpreter.primitive(f)
  }

  lazy val FirehoseInterpreter: FirehoseOp ~> Kleisli[M, FirehoseClient, *] = new FirehoseInterpreter {
    def primitive[A](f: FirehoseClient ⇒ A): Kleisli[M, FirehoseClient, A] = interpreter.primitive(f)
  }

  lazy val FisInterpreter: FisOp ~> Kleisli[M, FisClient, *] = new FisInterpreter {
    def primitive[A](f: FisClient ⇒ A): Kleisli[M, FisClient, A] = interpreter.primitive(f)
  }

  lazy val FmsInterpreter: FmsOp ~> Kleisli[M, FmsClient, *] = new FmsInterpreter {
    def primitive[A](f: FmsClient ⇒ A): Kleisli[M, FmsClient, A] = interpreter.primitive(f)
  }

  lazy val ForecastInterpreter: ForecastOp ~> Kleisli[M, ForecastClient, *] = new ForecastInterpreter {
    def primitive[A](f: ForecastClient ⇒ A): Kleisli[M, ForecastClient, A] = interpreter.primitive(f)
  }

  lazy val ForecastqueryInterpreter: ForecastqueryOp ~> Kleisli[M, ForecastqueryClient, *] = new ForecastqueryInterpreter {
    def primitive[A](f: ForecastqueryClient ⇒ A): Kleisli[M, ForecastqueryClient, A] = interpreter.primitive(f)
  }

  lazy val FraudDetectorInterpreter: FraudDetectorOp ~> Kleisli[M, FraudDetectorClient, *] = new FraudDetectorInterpreter {
    def primitive[A](f: FraudDetectorClient ⇒ A): Kleisli[M, FraudDetectorClient, A] = interpreter.primitive(f)
  }

  lazy val GameLiftInterpreter: GameLiftOp ~> Kleisli[M, GameLiftClient, *] = new GameLiftInterpreter {
    def primitive[A](f: GameLiftClient ⇒ A): Kleisli[M, GameLiftClient, A] = interpreter.primitive(f)
  }

  lazy val GlacierInterpreter: GlacierOp ~> Kleisli[M, GlacierClient, *] = new GlacierInterpreter {
    def primitive[A](f: GlacierClient ⇒ A): Kleisli[M, GlacierClient, A] = interpreter.primitive(f)
  }

  lazy val GlobalAcceleratorInterpreter: GlobalAcceleratorOp ~> Kleisli[M, GlobalAcceleratorClient, *] = new GlobalAcceleratorInterpreter {
    def primitive[A](f: GlobalAcceleratorClient ⇒ A): Kleisli[M, GlobalAcceleratorClient, A] = interpreter.primitive(f)
  }

  lazy val GlueInterpreter: GlueOp ~> Kleisli[M, GlueClient, *] = new GlueInterpreter {
    def primitive[A](f: GlueClient ⇒ A): Kleisli[M, GlueClient, A] = interpreter.primitive(f)
  }

  lazy val GreengrassInterpreter: GreengrassOp ~> Kleisli[M, GreengrassClient, *] = new GreengrassInterpreter {
    def primitive[A](f: GreengrassClient ⇒ A): Kleisli[M, GreengrassClient, A] = interpreter.primitive(f)
  }

  lazy val GreengrassV2Interpreter: GreengrassV2Op ~> Kleisli[M, GreengrassV2Client, *] = new GreengrassV2Interpreter {
    def primitive[A](f: GreengrassV2Client ⇒ A): Kleisli[M, GreengrassV2Client, A] = interpreter.primitive(f)
  }

  lazy val GroundStationInterpreter: GroundStationOp ~> Kleisli[M, GroundStationClient, *] = new GroundStationInterpreter {
    def primitive[A](f: GroundStationClient ⇒ A): Kleisli[M, GroundStationClient, A] = interpreter.primitive(f)
  }

  lazy val GuardDutyInterpreter: GuardDutyOp ~> Kleisli[M, GuardDutyClient, *] = new GuardDutyInterpreter {
    def primitive[A](f: GuardDutyClient ⇒ A): Kleisli[M, GuardDutyClient, A] = interpreter.primitive(f)
  }

  lazy val HealthInterpreter: HealthOp ~> Kleisli[M, HealthClient, *] = new HealthInterpreter {
    def primitive[A](f: HealthClient ⇒ A): Kleisli[M, HealthClient, A] = interpreter.primitive(f)
  }

  lazy val HealthLakeInterpreter: HealthLakeOp ~> Kleisli[M, HealthLakeClient, *] = new HealthLakeInterpreter {
    def primitive[A](f: HealthLakeClient ⇒ A): Kleisli[M, HealthLakeClient, A] = interpreter.primitive(f)
  }

  lazy val HoneycodeInterpreter: HoneycodeOp ~> Kleisli[M, HoneycodeClient, *] = new HoneycodeInterpreter {
    def primitive[A](f: HoneycodeClient ⇒ A): Kleisli[M, HoneycodeClient, A] = interpreter.primitive(f)
  }

  lazy val IamInterpreter: IamOp ~> Kleisli[M, IamClient, *] = new IamInterpreter {
    def primitive[A](f: IamClient ⇒ A): Kleisli[M, IamClient, A] = interpreter.primitive(f)
  }

  lazy val IdentitystoreInterpreter: IdentitystoreOp ~> Kleisli[M, IdentitystoreClient, *] = new IdentitystoreInterpreter {
    def primitive[A](f: IdentitystoreClient ⇒ A): Kleisli[M, IdentitystoreClient, A] = interpreter.primitive(f)
  }

  lazy val ImagebuilderInterpreter: ImagebuilderOp ~> Kleisli[M, ImagebuilderClient, *] = new ImagebuilderInterpreter {
    def primitive[A](f: ImagebuilderClient ⇒ A): Kleisli[M, ImagebuilderClient, A] = interpreter.primitive(f)
  }

  lazy val InspectorInterpreter: InspectorOp ~> Kleisli[M, InspectorClient, *] = new InspectorInterpreter {
    def primitive[A](f: InspectorClient ⇒ A): Kleisli[M, InspectorClient, A] = interpreter.primitive(f)
  }

  lazy val IoTAnalyticsInterpreter: IoTAnalyticsOp ~> Kleisli[M, IoTAnalyticsClient, *] = new IoTAnalyticsInterpreter {
    def primitive[A](f: IoTAnalyticsClient ⇒ A): Kleisli[M, IoTAnalyticsClient, A] = interpreter.primitive(f)
  }

  lazy val IoTFleetHubInterpreter: IoTFleetHubOp ~> Kleisli[M, IoTFleetHubClient, *] = new IoTFleetHubInterpreter {
    def primitive[A](f: IoTFleetHubClient ⇒ A): Kleisli[M, IoTFleetHubClient, A] = interpreter.primitive(f)
  }

  lazy val IoTSecureTunnelingInterpreter: IoTSecureTunnelingOp ~> Kleisli[M, IoTSecureTunnelingClient, *] = new IoTSecureTunnelingInterpreter {
    def primitive[A](f: IoTSecureTunnelingClient ⇒ A): Kleisli[M, IoTSecureTunnelingClient, A] = interpreter.primitive(f)
  }

  lazy val IoTSiteWiseInterpreter: IoTSiteWiseOp ~> Kleisli[M, IoTSiteWiseClient, *] = new IoTSiteWiseInterpreter {
    def primitive[A](f: IoTSiteWiseClient ⇒ A): Kleisli[M, IoTSiteWiseClient, A] = interpreter.primitive(f)
  }

  lazy val IoTThingsGraphInterpreter: IoTThingsGraphOp ~> Kleisli[M, IoTThingsGraphClient, *] = new IoTThingsGraphInterpreter {
    def primitive[A](f: IoTThingsGraphClient ⇒ A): Kleisli[M, IoTThingsGraphClient, A] = interpreter.primitive(f)
  }

  lazy val IotInterpreter: IotOp ~> Kleisli[M, IotClient, *] = new IotInterpreter {
    def primitive[A](f: IotClient ⇒ A): Kleisli[M, IotClient, A] = interpreter.primitive(f)
  }

  lazy val Iot1ClickDevicesInterpreter: Iot1ClickDevicesOp ~> Kleisli[M, Iot1ClickDevicesClient, *] = new Iot1ClickDevicesInterpreter {
    def primitive[A](f: Iot1ClickDevicesClient ⇒ A): Kleisli[M, Iot1ClickDevicesClient, A] = interpreter.primitive(f)
  }

  lazy val Iot1ClickProjectsInterpreter: Iot1ClickProjectsOp ~> Kleisli[M, Iot1ClickProjectsClient, *] = new Iot1ClickProjectsInterpreter {
    def primitive[A](f: Iot1ClickProjectsClient ⇒ A): Kleisli[M, Iot1ClickProjectsClient, A] = interpreter.primitive(f)
  }

  lazy val IotDataPlaneInterpreter: IotDataPlaneOp ~> Kleisli[M, IotDataPlaneClient, *] = new IotDataPlaneInterpreter {
    def primitive[A](f: IotDataPlaneClient ⇒ A): Kleisli[M, IotDataPlaneClient, A] = interpreter.primitive(f)
  }

  lazy val IotDeviceAdvisorInterpreter: IotDeviceAdvisorOp ~> Kleisli[M, IotDeviceAdvisorClient, *] = new IotDeviceAdvisorInterpreter {
    def primitive[A](f: IotDeviceAdvisorClient ⇒ A): Kleisli[M, IotDeviceAdvisorClient, A] = interpreter.primitive(f)
  }

  lazy val IotEventsInterpreter: IotEventsOp ~> Kleisli[M, IotEventsClient, *] = new IotEventsInterpreter {
    def primitive[A](f: IotEventsClient ⇒ A): Kleisli[M, IotEventsClient, A] = interpreter.primitive(f)
  }

  lazy val IotEventsDataInterpreter: IotEventsDataOp ~> Kleisli[M, IotEventsDataClient, *] = new IotEventsDataInterpreter {
    def primitive[A](f: IotEventsDataClient ⇒ A): Kleisli[M, IotEventsDataClient, A] = interpreter.primitive(f)
  }

  lazy val IotJobsDataPlaneInterpreter: IotJobsDataPlaneOp ~> Kleisli[M, IotJobsDataPlaneClient, *] = new IotJobsDataPlaneInterpreter {
    def primitive[A](f: IotJobsDataPlaneClient ⇒ A): Kleisli[M, IotJobsDataPlaneClient, A] = interpreter.primitive(f)
  }

  lazy val IotWirelessInterpreter: IotWirelessOp ~> Kleisli[M, IotWirelessClient, *] = new IotWirelessInterpreter {
    def primitive[A](f: IotWirelessClient ⇒ A): Kleisli[M, IotWirelessClient, A] = interpreter.primitive(f)
  }

  lazy val IvsInterpreter: IvsOp ~> Kleisli[M, IvsClient, *] = new IvsInterpreter {
    def primitive[A](f: IvsClient ⇒ A): Kleisli[M, IvsClient, A] = interpreter.primitive(f)
  }

  lazy val KafkaInterpreter: KafkaOp ~> Kleisli[M, KafkaClient, *] = new KafkaInterpreter {
    def primitive[A](f: KafkaClient ⇒ A): Kleisli[M, KafkaClient, A] = interpreter.primitive(f)
  }

  lazy val KendraInterpreter: KendraOp ~> Kleisli[M, KendraClient, *] = new KendraInterpreter {
    def primitive[A](f: KendraClient ⇒ A): Kleisli[M, KendraClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisInterpreter: KinesisOp ~> Kleisli[M, KinesisClient, *] = new KinesisInterpreter {
    def primitive[A](f: KinesisClient ⇒ A): Kleisli[M, KinesisClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisAnalyticsInterpreter: KinesisAnalyticsOp ~> Kleisli[M, KinesisAnalyticsClient, *] = new KinesisAnalyticsInterpreter {
    def primitive[A](f: KinesisAnalyticsClient ⇒ A): Kleisli[M, KinesisAnalyticsClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisAnalyticsV2Interpreter: KinesisAnalyticsV2Op ~> Kleisli[M, KinesisAnalyticsV2Client, *] = new KinesisAnalyticsV2Interpreter {
    def primitive[A](f: KinesisAnalyticsV2Client ⇒ A): Kleisli[M, KinesisAnalyticsV2Client, A] = interpreter.primitive(f)
  }

  lazy val KinesisVideoInterpreter: KinesisVideoOp ~> Kleisli[M, KinesisVideoClient, *] = new KinesisVideoInterpreter {
    def primitive[A](f: KinesisVideoClient ⇒ A): Kleisli[M, KinesisVideoClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisVideoArchivedMediaInterpreter: KinesisVideoArchivedMediaOp ~> Kleisli[M, KinesisVideoArchivedMediaClient, *] = new KinesisVideoArchivedMediaInterpreter {
    def primitive[A](f: KinesisVideoArchivedMediaClient ⇒ A): Kleisli[M, KinesisVideoArchivedMediaClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisVideoMediaInterpreter: KinesisVideoMediaOp ~> Kleisli[M, KinesisVideoMediaClient, *] = new KinesisVideoMediaInterpreter {
    def primitive[A](f: KinesisVideoMediaClient ⇒ A): Kleisli[M, KinesisVideoMediaClient, A] = interpreter.primitive(f)
  }

  lazy val KinesisVideoSignalingInterpreter: KinesisVideoSignalingOp ~> Kleisli[M, KinesisVideoSignalingClient, *] = new KinesisVideoSignalingInterpreter {
    def primitive[A](f: KinesisVideoSignalingClient ⇒ A): Kleisli[M, KinesisVideoSignalingClient, A] = interpreter.primitive(f)
  }

  lazy val KmsInterpreter: KmsOp ~> Kleisli[M, KmsClient, *] = new KmsInterpreter {
    def primitive[A](f: KmsClient ⇒ A): Kleisli[M, KmsClient, A] = interpreter.primitive(f)
  }

  lazy val LakeFormationInterpreter: LakeFormationOp ~> Kleisli[M, LakeFormationClient, *] = new LakeFormationInterpreter {
    def primitive[A](f: LakeFormationClient ⇒ A): Kleisli[M, LakeFormationClient, A] = interpreter.primitive(f)
  }

  lazy val LambdaInterpreter: LambdaOp ~> Kleisli[M, LambdaClient, *] = new LambdaInterpreter {
    def primitive[A](f: LambdaClient ⇒ A): Kleisli[M, LambdaClient, A] = interpreter.primitive(f)
  }

  lazy val LexModelBuildingInterpreter: LexModelBuildingOp ~> Kleisli[M, LexModelBuildingClient, *] = new LexModelBuildingInterpreter {
    def primitive[A](f: LexModelBuildingClient ⇒ A): Kleisli[M, LexModelBuildingClient, A] = interpreter.primitive(f)
  }

  lazy val LexModelsV2Interpreter: LexModelsV2Op ~> Kleisli[M, LexModelsV2Client, *] = new LexModelsV2Interpreter {
    def primitive[A](f: LexModelsV2Client ⇒ A): Kleisli[M, LexModelsV2Client, A] = interpreter.primitive(f)
  }

  lazy val LexRuntimeInterpreter: LexRuntimeOp ~> Kleisli[M, LexRuntimeClient, *] = new LexRuntimeInterpreter {
    def primitive[A](f: LexRuntimeClient ⇒ A): Kleisli[M, LexRuntimeClient, A] = interpreter.primitive(f)
  }

  lazy val LexRuntimeV2Interpreter: LexRuntimeV2Op ~> Kleisli[M, LexRuntimeV2Client, *] = new LexRuntimeV2Interpreter {
    def primitive[A](f: LexRuntimeV2Client ⇒ A): Kleisli[M, LexRuntimeV2Client, A] = interpreter.primitive(f)
  }

  lazy val LicenseManagerInterpreter: LicenseManagerOp ~> Kleisli[M, LicenseManagerClient, *] = new LicenseManagerInterpreter {
    def primitive[A](f: LicenseManagerClient ⇒ A): Kleisli[M, LicenseManagerClient, A] = interpreter.primitive(f)
  }

  lazy val LightsailInterpreter: LightsailOp ~> Kleisli[M, LightsailClient, *] = new LightsailInterpreter {
    def primitive[A](f: LightsailClient ⇒ A): Kleisli[M, LightsailClient, A] = interpreter.primitive(f)
  }

  lazy val LocationInterpreter: LocationOp ~> Kleisli[M, LocationClient, *] = new LocationInterpreter {
    def primitive[A](f: LocationClient ⇒ A): Kleisli[M, LocationClient, A] = interpreter.primitive(f)
  }

  lazy val LookoutEquipmentInterpreter: LookoutEquipmentOp ~> Kleisli[M, LookoutEquipmentClient, *] = new LookoutEquipmentInterpreter {
    def primitive[A](f: LookoutEquipmentClient ⇒ A): Kleisli[M, LookoutEquipmentClient, A] = interpreter.primitive(f)
  }

  lazy val LookoutMetricsInterpreter: LookoutMetricsOp ~> Kleisli[M, LookoutMetricsClient, *] = new LookoutMetricsInterpreter {
    def primitive[A](f: LookoutMetricsClient ⇒ A): Kleisli[M, LookoutMetricsClient, A] = interpreter.primitive(f)
  }

  lazy val LookoutVisionInterpreter: LookoutVisionOp ~> Kleisli[M, LookoutVisionClient, *] = new LookoutVisionInterpreter {
    def primitive[A](f: LookoutVisionClient ⇒ A): Kleisli[M, LookoutVisionClient, A] = interpreter.primitive(f)
  }

  lazy val MTurkInterpreter: MTurkOp ~> Kleisli[M, MTurkClient, *] = new MTurkInterpreter {
    def primitive[A](f: MTurkClient ⇒ A): Kleisli[M, MTurkClient, A] = interpreter.primitive(f)
  }

  lazy val MachineLearningInterpreter: MachineLearningOp ~> Kleisli[M, MachineLearningClient, *] = new MachineLearningInterpreter {
    def primitive[A](f: MachineLearningClient ⇒ A): Kleisli[M, MachineLearningClient, A] = interpreter.primitive(f)
  }

  lazy val MacieInterpreter: MacieOp ~> Kleisli[M, MacieClient, *] = new MacieInterpreter {
    def primitive[A](f: MacieClient ⇒ A): Kleisli[M, MacieClient, A] = interpreter.primitive(f)
  }

  lazy val Macie2Interpreter: Macie2Op ~> Kleisli[M, Macie2Client, *] = new Macie2Interpreter {
    def primitive[A](f: Macie2Client ⇒ A): Kleisli[M, Macie2Client, A] = interpreter.primitive(f)
  }

  lazy val ManagedBlockchainInterpreter: ManagedBlockchainOp ~> Kleisli[M, ManagedBlockchainClient, *] = new ManagedBlockchainInterpreter {
    def primitive[A](f: ManagedBlockchainClient ⇒ A): Kleisli[M, ManagedBlockchainClient, A] = interpreter.primitive(f)
  }

  lazy val MarketplaceCatalogInterpreter: MarketplaceCatalogOp ~> Kleisli[M, MarketplaceCatalogClient, *] = new MarketplaceCatalogInterpreter {
    def primitive[A](f: MarketplaceCatalogClient ⇒ A): Kleisli[M, MarketplaceCatalogClient, A] = interpreter.primitive(f)
  }

  lazy val MarketplaceCommerceAnalyticsInterpreter: MarketplaceCommerceAnalyticsOp ~> Kleisli[M, MarketplaceCommerceAnalyticsClient, *] = new MarketplaceCommerceAnalyticsInterpreter {
    def primitive[A](f: MarketplaceCommerceAnalyticsClient ⇒ A): Kleisli[M, MarketplaceCommerceAnalyticsClient, A] = interpreter.primitive(f)
  }

  lazy val MarketplaceEntitlementInterpreter: MarketplaceEntitlementOp ~> Kleisli[M, MarketplaceEntitlementClient, *] = new MarketplaceEntitlementInterpreter {
    def primitive[A](f: MarketplaceEntitlementClient ⇒ A): Kleisli[M, MarketplaceEntitlementClient, A] = interpreter.primitive(f)
  }

  lazy val MarketplaceMeteringInterpreter: MarketplaceMeteringOp ~> Kleisli[M, MarketplaceMeteringClient, *] = new MarketplaceMeteringInterpreter {
    def primitive[A](f: MarketplaceMeteringClient ⇒ A): Kleisli[M, MarketplaceMeteringClient, A] = interpreter.primitive(f)
  }

  lazy val MediaConnectInterpreter: MediaConnectOp ~> Kleisli[M, MediaConnectClient, *] = new MediaConnectInterpreter {
    def primitive[A](f: MediaConnectClient ⇒ A): Kleisli[M, MediaConnectClient, A] = interpreter.primitive(f)
  }

  lazy val MediaConvertInterpreter: MediaConvertOp ~> Kleisli[M, MediaConvertClient, *] = new MediaConvertInterpreter {
    def primitive[A](f: MediaConvertClient ⇒ A): Kleisli[M, MediaConvertClient, A] = interpreter.primitive(f)
  }

  lazy val MediaLiveInterpreter: MediaLiveOp ~> Kleisli[M, MediaLiveClient, *] = new MediaLiveInterpreter {
    def primitive[A](f: MediaLiveClient ⇒ A): Kleisli[M, MediaLiveClient, A] = interpreter.primitive(f)
  }

  lazy val MediaPackageInterpreter: MediaPackageOp ~> Kleisli[M, MediaPackageClient, *] = new MediaPackageInterpreter {
    def primitive[A](f: MediaPackageClient ⇒ A): Kleisli[M, MediaPackageClient, A] = interpreter.primitive(f)
  }

  lazy val MediaPackageVodInterpreter: MediaPackageVodOp ~> Kleisli[M, MediaPackageVodClient, *] = new MediaPackageVodInterpreter {
    def primitive[A](f: MediaPackageVodClient ⇒ A): Kleisli[M, MediaPackageVodClient, A] = interpreter.primitive(f)
  }

  lazy val MediaStoreInterpreter: MediaStoreOp ~> Kleisli[M, MediaStoreClient, *] = new MediaStoreInterpreter {
    def primitive[A](f: MediaStoreClient ⇒ A): Kleisli[M, MediaStoreClient, A] = interpreter.primitive(f)
  }

  lazy val MediaStoreDataInterpreter: MediaStoreDataOp ~> Kleisli[M, MediaStoreDataClient, *] = new MediaStoreDataInterpreter {
    def primitive[A](f: MediaStoreDataClient ⇒ A): Kleisli[M, MediaStoreDataClient, A] = interpreter.primitive(f)
  }

  lazy val MediaTailorInterpreter: MediaTailorOp ~> Kleisli[M, MediaTailorClient, *] = new MediaTailorInterpreter {
    def primitive[A](f: MediaTailorClient ⇒ A): Kleisli[M, MediaTailorClient, A] = interpreter.primitive(f)
  }

  lazy val MgnInterpreter: MgnOp ~> Kleisli[M, MgnClient, *] = new MgnInterpreter {
    def primitive[A](f: MgnClient ⇒ A): Kleisli[M, MgnClient, A] = interpreter.primitive(f)
  }

  lazy val MigrationHubInterpreter: MigrationHubOp ~> Kleisli[M, MigrationHubClient, *] = new MigrationHubInterpreter {
    def primitive[A](f: MigrationHubClient ⇒ A): Kleisli[M, MigrationHubClient, A] = interpreter.primitive(f)
  }

  lazy val MigrationHubConfigInterpreter: MigrationHubConfigOp ~> Kleisli[M, MigrationHubConfigClient, *] = new MigrationHubConfigInterpreter {
    def primitive[A](f: MigrationHubConfigClient ⇒ A): Kleisli[M, MigrationHubConfigClient, A] = interpreter.primitive(f)
  }

  lazy val MobileInterpreter: MobileOp ~> Kleisli[M, MobileClient, *] = new MobileInterpreter {
    def primitive[A](f: MobileClient ⇒ A): Kleisli[M, MobileClient, A] = interpreter.primitive(f)
  }

  lazy val MqInterpreter: MqOp ~> Kleisli[M, MqClient, *] = new MqInterpreter {
    def primitive[A](f: MqClient ⇒ A): Kleisli[M, MqClient, A] = interpreter.primitive(f)
  }

  lazy val MwaaInterpreter: MwaaOp ~> Kleisli[M, MwaaClient, *] = new MwaaInterpreter {
    def primitive[A](f: MwaaClient ⇒ A): Kleisli[M, MwaaClient, A] = interpreter.primitive(f)
  }

  lazy val NeptuneInterpreter: NeptuneOp ~> Kleisli[M, NeptuneClient, *] = new NeptuneInterpreter {
    def primitive[A](f: NeptuneClient ⇒ A): Kleisli[M, NeptuneClient, A] = interpreter.primitive(f)
  }

  lazy val NetworkFirewallInterpreter: NetworkFirewallOp ~> Kleisli[M, NetworkFirewallClient, *] = new NetworkFirewallInterpreter {
    def primitive[A](f: NetworkFirewallClient ⇒ A): Kleisli[M, NetworkFirewallClient, A] = interpreter.primitive(f)
  }

  lazy val NetworkManagerInterpreter: NetworkManagerOp ~> Kleisli[M, NetworkManagerClient, *] = new NetworkManagerInterpreter {
    def primitive[A](f: NetworkManagerClient ⇒ A): Kleisli[M, NetworkManagerClient, A] = interpreter.primitive(f)
  }

  lazy val NimbleInterpreter: NimbleOp ~> Kleisli[M, NimbleClient, *] = new NimbleInterpreter {
    def primitive[A](f: NimbleClient ⇒ A): Kleisli[M, NimbleClient, A] = interpreter.primitive(f)
  }

  lazy val OpsWorksInterpreter: OpsWorksOp ~> Kleisli[M, OpsWorksClient, *] = new OpsWorksInterpreter {
    def primitive[A](f: OpsWorksClient ⇒ A): Kleisli[M, OpsWorksClient, A] = interpreter.primitive(f)
  }

  lazy val OpsWorksCmInterpreter: OpsWorksCmOp ~> Kleisli[M, OpsWorksCmClient, *] = new OpsWorksCmInterpreter {
    def primitive[A](f: OpsWorksCmClient ⇒ A): Kleisli[M, OpsWorksCmClient, A] = interpreter.primitive(f)
  }

  lazy val OrganizationsInterpreter: OrganizationsOp ~> Kleisli[M, OrganizationsClient, *] = new OrganizationsInterpreter {
    def primitive[A](f: OrganizationsClient ⇒ A): Kleisli[M, OrganizationsClient, A] = interpreter.primitive(f)
  }

  lazy val OutpostsInterpreter: OutpostsOp ~> Kleisli[M, OutpostsClient, *] = new OutpostsInterpreter {
    def primitive[A](f: OutpostsClient ⇒ A): Kleisli[M, OutpostsClient, A] = interpreter.primitive(f)
  }

  lazy val PersonalizeInterpreter: PersonalizeOp ~> Kleisli[M, PersonalizeClient, *] = new PersonalizeInterpreter {
    def primitive[A](f: PersonalizeClient ⇒ A): Kleisli[M, PersonalizeClient, A] = interpreter.primitive(f)
  }

  lazy val PersonalizeEventsInterpreter: PersonalizeEventsOp ~> Kleisli[M, PersonalizeEventsClient, *] = new PersonalizeEventsInterpreter {
    def primitive[A](f: PersonalizeEventsClient ⇒ A): Kleisli[M, PersonalizeEventsClient, A] = interpreter.primitive(f)
  }

  lazy val PersonalizeRuntimeInterpreter: PersonalizeRuntimeOp ~> Kleisli[M, PersonalizeRuntimeClient, *] = new PersonalizeRuntimeInterpreter {
    def primitive[A](f: PersonalizeRuntimeClient ⇒ A): Kleisli[M, PersonalizeRuntimeClient, A] = interpreter.primitive(f)
  }

  lazy val PiInterpreter: PiOp ~> Kleisli[M, PiClient, *] = new PiInterpreter {
    def primitive[A](f: PiClient ⇒ A): Kleisli[M, PiClient, A] = interpreter.primitive(f)
  }

  lazy val PinpointInterpreter: PinpointOp ~> Kleisli[M, PinpointClient, *] = new PinpointInterpreter {
    def primitive[A](f: PinpointClient ⇒ A): Kleisli[M, PinpointClient, A] = interpreter.primitive(f)
  }

  lazy val PinpointEmailInterpreter: PinpointEmailOp ~> Kleisli[M, PinpointEmailClient, *] = new PinpointEmailInterpreter {
    def primitive[A](f: PinpointEmailClient ⇒ A): Kleisli[M, PinpointEmailClient, A] = interpreter.primitive(f)
  }

  lazy val PinpointSmsVoiceInterpreter: PinpointSmsVoiceOp ~> Kleisli[M, PinpointSmsVoiceClient, *] = new PinpointSmsVoiceInterpreter {
    def primitive[A](f: PinpointSmsVoiceClient ⇒ A): Kleisli[M, PinpointSmsVoiceClient, A] = interpreter.primitive(f)
  }

  lazy val PollyInterpreter: PollyOp ~> Kleisli[M, PollyClient, *] = new PollyInterpreter {
    def primitive[A](f: PollyClient ⇒ A): Kleisli[M, PollyClient, A] = interpreter.primitive(f)
  }

  lazy val PricingInterpreter: PricingOp ~> Kleisli[M, PricingClient, *] = new PricingInterpreter {
    def primitive[A](f: PricingClient ⇒ A): Kleisli[M, PricingClient, A] = interpreter.primitive(f)
  }

  lazy val ProtonInterpreter: ProtonOp ~> Kleisli[M, ProtonClient, *] = new ProtonInterpreter {
    def primitive[A](f: ProtonClient ⇒ A): Kleisli[M, ProtonClient, A] = interpreter.primitive(f)
  }

  lazy val QldbInterpreter: QldbOp ~> Kleisli[M, QldbClient, *] = new QldbInterpreter {
    def primitive[A](f: QldbClient ⇒ A): Kleisli[M, QldbClient, A] = interpreter.primitive(f)
  }

  lazy val QldbSessionInterpreter: QldbSessionOp ~> Kleisli[M, QldbSessionClient, *] = new QldbSessionInterpreter {
    def primitive[A](f: QldbSessionClient ⇒ A): Kleisli[M, QldbSessionClient, A] = interpreter.primitive(f)
  }

  lazy val QuickSightInterpreter: QuickSightOp ~> Kleisli[M, QuickSightClient, *] = new QuickSightInterpreter {
    def primitive[A](f: QuickSightClient ⇒ A): Kleisli[M, QuickSightClient, A] = interpreter.primitive(f)
  }

  lazy val RamInterpreter: RamOp ~> Kleisli[M, RamClient, *] = new RamInterpreter {
    def primitive[A](f: RamClient ⇒ A): Kleisli[M, RamClient, A] = interpreter.primitive(f)
  }

  lazy val RdsInterpreter: RdsOp ~> Kleisli[M, RdsClient, *] = new RdsInterpreter {
    def primitive[A](f: RdsClient ⇒ A): Kleisli[M, RdsClient, A] = interpreter.primitive(f)
  }

  lazy val RdsDataInterpreter: RdsDataOp ~> Kleisli[M, RdsDataClient, *] = new RdsDataInterpreter {
    def primitive[A](f: RdsDataClient ⇒ A): Kleisli[M, RdsDataClient, A] = interpreter.primitive(f)
  }

  lazy val RedshiftInterpreter: RedshiftOp ~> Kleisli[M, RedshiftClient, *] = new RedshiftInterpreter {
    def primitive[A](f: RedshiftClient ⇒ A): Kleisli[M, RedshiftClient, A] = interpreter.primitive(f)
  }

  lazy val RedshiftDataInterpreter: RedshiftDataOp ~> Kleisli[M, RedshiftDataClient, *] = new RedshiftDataInterpreter {
    def primitive[A](f: RedshiftDataClient ⇒ A): Kleisli[M, RedshiftDataClient, A] = interpreter.primitive(f)
  }

  lazy val RekognitionInterpreter: RekognitionOp ~> Kleisli[M, RekognitionClient, *] = new RekognitionInterpreter {
    def primitive[A](f: RekognitionClient ⇒ A): Kleisli[M, RekognitionClient, A] = interpreter.primitive(f)
  }

  lazy val ResourceGroupsInterpreter: ResourceGroupsOp ~> Kleisli[M, ResourceGroupsClient, *] = new ResourceGroupsInterpreter {
    def primitive[A](f: ResourceGroupsClient ⇒ A): Kleisli[M, ResourceGroupsClient, A] = interpreter.primitive(f)
  }

  lazy val ResourceGroupsTaggingApiInterpreter: ResourceGroupsTaggingApiOp ~> Kleisli[M, ResourceGroupsTaggingApiClient, *] = new ResourceGroupsTaggingApiInterpreter {
    def primitive[A](f: ResourceGroupsTaggingApiClient ⇒ A): Kleisli[M, ResourceGroupsTaggingApiClient, A] = interpreter.primitive(f)
  }

  lazy val RoboMakerInterpreter: RoboMakerOp ~> Kleisli[M, RoboMakerClient, *] = new RoboMakerInterpreter {
    def primitive[A](f: RoboMakerClient ⇒ A): Kleisli[M, RoboMakerClient, A] = interpreter.primitive(f)
  }

  lazy val Route53Interpreter: Route53Op ~> Kleisli[M, Route53Client, *] = new Route53Interpreter {
    def primitive[A](f: Route53Client ⇒ A): Kleisli[M, Route53Client, A] = interpreter.primitive(f)
  }

  lazy val Route53DomainsInterpreter: Route53DomainsOp ~> Kleisli[M, Route53DomainsClient, *] = new Route53DomainsInterpreter {
    def primitive[A](f: Route53DomainsClient ⇒ A): Kleisli[M, Route53DomainsClient, A] = interpreter.primitive(f)
  }

  lazy val Route53ResolverInterpreter: Route53ResolverOp ~> Kleisli[M, Route53ResolverClient, *] = new Route53ResolverInterpreter {
    def primitive[A](f: Route53ResolverClient ⇒ A): Kleisli[M, Route53ResolverClient, A] = interpreter.primitive(f)
  }

  lazy val S3Interpreter: S3Op ~> Kleisli[M, S3Client, *] = new S3Interpreter {
    def primitive[A](f: S3Client ⇒ A): Kleisli[M, S3Client, A] = interpreter.primitive(f)
  }

  lazy val S3ControlInterpreter: S3ControlOp ~> Kleisli[M, S3ControlClient, *] = new S3ControlInterpreter {
    def primitive[A](f: S3ControlClient ⇒ A): Kleisli[M, S3ControlClient, A] = interpreter.primitive(f)
  }

  lazy val S3OutpostsInterpreter: S3OutpostsOp ~> Kleisli[M, S3OutpostsClient, *] = new S3OutpostsInterpreter {
    def primitive[A](f: S3OutpostsClient ⇒ A): Kleisli[M, S3OutpostsClient, A] = interpreter.primitive(f)
  }

  lazy val SageMakerInterpreter: SageMakerOp ~> Kleisli[M, SageMakerClient, *] = new SageMakerInterpreter {
    def primitive[A](f: SageMakerClient ⇒ A): Kleisli[M, SageMakerClient, A] = interpreter.primitive(f)
  }

  lazy val SageMakerA2IRuntimeInterpreter: SageMakerA2IRuntimeOp ~> Kleisli[M, SageMakerA2IRuntimeClient, *] = new SageMakerA2IRuntimeInterpreter {
    def primitive[A](f: SageMakerA2IRuntimeClient ⇒ A): Kleisli[M, SageMakerA2IRuntimeClient, A] = interpreter.primitive(f)
  }

  lazy val SageMakerFeatureStoreRuntimeInterpreter: SageMakerFeatureStoreRuntimeOp ~> Kleisli[M, SageMakerFeatureStoreRuntimeClient, *] = new SageMakerFeatureStoreRuntimeInterpreter {
    def primitive[A](f: SageMakerFeatureStoreRuntimeClient ⇒ A): Kleisli[M, SageMakerFeatureStoreRuntimeClient, A] = interpreter.primitive(f)
  }

  lazy val SageMakerRuntimeInterpreter: SageMakerRuntimeOp ~> Kleisli[M, SageMakerRuntimeClient, *] = new SageMakerRuntimeInterpreter {
    def primitive[A](f: SageMakerRuntimeClient ⇒ A): Kleisli[M, SageMakerRuntimeClient, A] = interpreter.primitive(f)
  }

  lazy val SagemakerEdgeInterpreter: SagemakerEdgeOp ~> Kleisli[M, SagemakerEdgeClient, *] = new SagemakerEdgeInterpreter {
    def primitive[A](f: SagemakerEdgeClient ⇒ A): Kleisli[M, SagemakerEdgeClient, A] = interpreter.primitive(f)
  }

  lazy val SavingsplansInterpreter: SavingsplansOp ~> Kleisli[M, SavingsplansClient, *] = new SavingsplansInterpreter {
    def primitive[A](f: SavingsplansClient ⇒ A): Kleisli[M, SavingsplansClient, A] = interpreter.primitive(f)
  }

  lazy val SchemasInterpreter: SchemasOp ~> Kleisli[M, SchemasClient, *] = new SchemasInterpreter {
    def primitive[A](f: SchemasClient ⇒ A): Kleisli[M, SchemasClient, A] = interpreter.primitive(f)
  }

  lazy val SecretsManagerInterpreter: SecretsManagerOp ~> Kleisli[M, SecretsManagerClient, *] = new SecretsManagerInterpreter {
    def primitive[A](f: SecretsManagerClient ⇒ A): Kleisli[M, SecretsManagerClient, A] = interpreter.primitive(f)
  }

  lazy val SecurityHubInterpreter: SecurityHubOp ~> Kleisli[M, SecurityHubClient, *] = new SecurityHubInterpreter {
    def primitive[A](f: SecurityHubClient ⇒ A): Kleisli[M, SecurityHubClient, A] = interpreter.primitive(f)
  }

  lazy val ServerlessApplicationRepositoryInterpreter: ServerlessApplicationRepositoryOp ~> Kleisli[M, ServerlessApplicationRepositoryClient, *] = new ServerlessApplicationRepositoryInterpreter {
    def primitive[A](f: ServerlessApplicationRepositoryClient ⇒ A): Kleisli[M, ServerlessApplicationRepositoryClient, A] = interpreter.primitive(f)
  }

  lazy val ServiceCatalogInterpreter: ServiceCatalogOp ~> Kleisli[M, ServiceCatalogClient, *] = new ServiceCatalogInterpreter {
    def primitive[A](f: ServiceCatalogClient ⇒ A): Kleisli[M, ServiceCatalogClient, A] = interpreter.primitive(f)
  }

  lazy val ServiceCatalogAppRegistryInterpreter: ServiceCatalogAppRegistryOp ~> Kleisli[M, ServiceCatalogAppRegistryClient, *] = new ServiceCatalogAppRegistryInterpreter {
    def primitive[A](f: ServiceCatalogAppRegistryClient ⇒ A): Kleisli[M, ServiceCatalogAppRegistryClient, A] = interpreter.primitive(f)
  }

  lazy val ServiceDiscoveryInterpreter: ServiceDiscoveryOp ~> Kleisli[M, ServiceDiscoveryClient, *] = new ServiceDiscoveryInterpreter {
    def primitive[A](f: ServiceDiscoveryClient ⇒ A): Kleisli[M, ServiceDiscoveryClient, A] = interpreter.primitive(f)
  }

  lazy val ServiceQuotasInterpreter: ServiceQuotasOp ~> Kleisli[M, ServiceQuotasClient, *] = new ServiceQuotasInterpreter {
    def primitive[A](f: ServiceQuotasClient ⇒ A): Kleisli[M, ServiceQuotasClient, A] = interpreter.primitive(f)
  }

  lazy val SesInterpreter: SesOp ~> Kleisli[M, SesClient, *] = new SesInterpreter {
    def primitive[A](f: SesClient ⇒ A): Kleisli[M, SesClient, A] = interpreter.primitive(f)
  }

  lazy val SesV2Interpreter: SesV2Op ~> Kleisli[M, SesV2Client, *] = new SesV2Interpreter {
    def primitive[A](f: SesV2Client ⇒ A): Kleisli[M, SesV2Client, A] = interpreter.primitive(f)
  }

  lazy val SfnInterpreter: SfnOp ~> Kleisli[M, SfnClient, *] = new SfnInterpreter {
    def primitive[A](f: SfnClient ⇒ A): Kleisli[M, SfnClient, A] = interpreter.primitive(f)
  }

  lazy val ShieldInterpreter: ShieldOp ~> Kleisli[M, ShieldClient, *] = new ShieldInterpreter {
    def primitive[A](f: ShieldClient ⇒ A): Kleisli[M, ShieldClient, A] = interpreter.primitive(f)
  }

  lazy val SignerInterpreter: SignerOp ~> Kleisli[M, SignerClient, *] = new SignerInterpreter {
    def primitive[A](f: SignerClient ⇒ A): Kleisli[M, SignerClient, A] = interpreter.primitive(f)
  }

  lazy val SmsInterpreter: SmsOp ~> Kleisli[M, SmsClient, *] = new SmsInterpreter {
    def primitive[A](f: SmsClient ⇒ A): Kleisli[M, SmsClient, A] = interpreter.primitive(f)
  }

  lazy val SnowballInterpreter: SnowballOp ~> Kleisli[M, SnowballClient, *] = new SnowballInterpreter {
    def primitive[A](f: SnowballClient ⇒ A): Kleisli[M, SnowballClient, A] = interpreter.primitive(f)
  }

  lazy val SnsInterpreter: SnsOp ~> Kleisli[M, SnsClient, *] = new SnsInterpreter {
    def primitive[A](f: SnsClient ⇒ A): Kleisli[M, SnsClient, A] = interpreter.primitive(f)
  }

  lazy val SqsInterpreter: SqsOp ~> Kleisli[M, SqsClient, *] = new SqsInterpreter {
    def primitive[A](f: SqsClient ⇒ A): Kleisli[M, SqsClient, A] = interpreter.primitive(f)
  }

  lazy val SsmInterpreter: SsmOp ~> Kleisli[M, SsmClient, *] = new SsmInterpreter {
    def primitive[A](f: SsmClient ⇒ A): Kleisli[M, SsmClient, A] = interpreter.primitive(f)
  }

  lazy val SsmContactsInterpreter: SsmContactsOp ~> Kleisli[M, SsmContactsClient, *] = new SsmContactsInterpreter {
    def primitive[A](f: SsmContactsClient ⇒ A): Kleisli[M, SsmContactsClient, A] = interpreter.primitive(f)
  }

  lazy val SsmIncidentsInterpreter: SsmIncidentsOp ~> Kleisli[M, SsmIncidentsClient, *] = new SsmIncidentsInterpreter {
    def primitive[A](f: SsmIncidentsClient ⇒ A): Kleisli[M, SsmIncidentsClient, A] = interpreter.primitive(f)
  }

  lazy val SsoInterpreter: SsoOp ~> Kleisli[M, SsoClient, *] = new SsoInterpreter {
    def primitive[A](f: SsoClient ⇒ A): Kleisli[M, SsoClient, A] = interpreter.primitive(f)
  }

  lazy val SsoAdminInterpreter: SsoAdminOp ~> Kleisli[M, SsoAdminClient, *] = new SsoAdminInterpreter {
    def primitive[A](f: SsoAdminClient ⇒ A): Kleisli[M, SsoAdminClient, A] = interpreter.primitive(f)
  }

  lazy val SsoOidcInterpreter: SsoOidcOp ~> Kleisli[M, SsoOidcClient, *] = new SsoOidcInterpreter {
    def primitive[A](f: SsoOidcClient ⇒ A): Kleisli[M, SsoOidcClient, A] = interpreter.primitive(f)
  }

  lazy val StorageGatewayInterpreter: StorageGatewayOp ~> Kleisli[M, StorageGatewayClient, *] = new StorageGatewayInterpreter {
    def primitive[A](f: StorageGatewayClient ⇒ A): Kleisli[M, StorageGatewayClient, A] = interpreter.primitive(f)
  }

  lazy val StsInterpreter: StsOp ~> Kleisli[M, StsClient, *] = new StsInterpreter {
    def primitive[A](f: StsClient ⇒ A): Kleisli[M, StsClient, A] = interpreter.primitive(f)
  }

  lazy val SupportInterpreter: SupportOp ~> Kleisli[M, SupportClient, *] = new SupportInterpreter {
    def primitive[A](f: SupportClient ⇒ A): Kleisli[M, SupportClient, A] = interpreter.primitive(f)
  }

  lazy val SwfInterpreter: SwfOp ~> Kleisli[M, SwfClient, *] = new SwfInterpreter {
    def primitive[A](f: SwfClient ⇒ A): Kleisli[M, SwfClient, A] = interpreter.primitive(f)
  }

  lazy val SyntheticsInterpreter: SyntheticsOp ~> Kleisli[M, SyntheticsClient, *] = new SyntheticsInterpreter {
    def primitive[A](f: SyntheticsClient ⇒ A): Kleisli[M, SyntheticsClient, A] = interpreter.primitive(f)
  }

  lazy val TextractInterpreter: TextractOp ~> Kleisli[M, TextractClient, *] = new TextractInterpreter {
    def primitive[A](f: TextractClient ⇒ A): Kleisli[M, TextractClient, A] = interpreter.primitive(f)
  }

  lazy val TimestreamQueryInterpreter: TimestreamQueryOp ~> Kleisli[M, TimestreamQueryClient, *] = new TimestreamQueryInterpreter {
    def primitive[A](f: TimestreamQueryClient ⇒ A): Kleisli[M, TimestreamQueryClient, A] = interpreter.primitive(f)
  }

  lazy val TimestreamWriteInterpreter: TimestreamWriteOp ~> Kleisli[M, TimestreamWriteClient, *] = new TimestreamWriteInterpreter {
    def primitive[A](f: TimestreamWriteClient ⇒ A): Kleisli[M, TimestreamWriteClient, A] = interpreter.primitive(f)
  }

  lazy val TranscribeInterpreter: TranscribeOp ~> Kleisli[M, TranscribeClient, *] = new TranscribeInterpreter {
    def primitive[A](f: TranscribeClient ⇒ A): Kleisli[M, TranscribeClient, A] = interpreter.primitive(f)
  }

  lazy val TransferInterpreter: TransferOp ~> Kleisli[M, TransferClient, *] = new TransferInterpreter {
    def primitive[A](f: TransferClient ⇒ A): Kleisli[M, TransferClient, A] = interpreter.primitive(f)
  }

  lazy val TranslateInterpreter: TranslateOp ~> Kleisli[M, TranslateClient, *] = new TranslateInterpreter {
    def primitive[A](f: TranslateClient ⇒ A): Kleisli[M, TranslateClient, A] = interpreter.primitive(f)
  }

  lazy val WafInterpreter: WafOp ~> Kleisli[M, WafClient, *] = new WafInterpreter {
    def primitive[A](f: WafClient ⇒ A): Kleisli[M, WafClient, A] = interpreter.primitive(f)
  }

  lazy val WafRegionalInterpreter: WafRegionalOp ~> Kleisli[M, WafRegionalClient, *] = new WafRegionalInterpreter {
    def primitive[A](f: WafRegionalClient ⇒ A): Kleisli[M, WafRegionalClient, A] = interpreter.primitive(f)
  }

  lazy val Wafv2Interpreter: Wafv2Op ~> Kleisli[M, Wafv2Client, *] = new Wafv2Interpreter {
    def primitive[A](f: Wafv2Client ⇒ A): Kleisli[M, Wafv2Client, A] = interpreter.primitive(f)
  }

  lazy val WellArchitectedInterpreter: WellArchitectedOp ~> Kleisli[M, WellArchitectedClient, *] = new WellArchitectedInterpreter {
    def primitive[A](f: WellArchitectedClient ⇒ A): Kleisli[M, WellArchitectedClient, A] = interpreter.primitive(f)
  }

  lazy val WorkDocsInterpreter: WorkDocsOp ~> Kleisli[M, WorkDocsClient, *] = new WorkDocsInterpreter {
    def primitive[A](f: WorkDocsClient ⇒ A): Kleisli[M, WorkDocsClient, A] = interpreter.primitive(f)
  }

  lazy val WorkLinkInterpreter: WorkLinkOp ~> Kleisli[M, WorkLinkClient, *] = new WorkLinkInterpreter {
    def primitive[A](f: WorkLinkClient ⇒ A): Kleisli[M, WorkLinkClient, A] = interpreter.primitive(f)
  }

  lazy val WorkMailInterpreter: WorkMailOp ~> Kleisli[M, WorkMailClient, *] = new WorkMailInterpreter {
    def primitive[A](f: WorkMailClient ⇒ A): Kleisli[M, WorkMailClient, A] = interpreter.primitive(f)
  }

  lazy val WorkMailMessageFlowInterpreter: WorkMailMessageFlowOp ~> Kleisli[M, WorkMailMessageFlowClient, *] = new WorkMailMessageFlowInterpreter {
    def primitive[A](f: WorkMailMessageFlowClient ⇒ A): Kleisli[M, WorkMailMessageFlowClient, A] = interpreter.primitive(f)
  }

  lazy val WorkSpacesInterpreter: WorkSpacesOp ~> Kleisli[M, WorkSpacesClient, *] = new WorkSpacesInterpreter {
    def primitive[A](f: WorkSpacesClient ⇒ A): Kleisli[M, WorkSpacesClient, A] = interpreter.primitive(f)
  }

  lazy val XRayInterpreter: XRayOp ~> Kleisli[M, XRayClient, *] = new XRayInterpreter {
    def primitive[A](f: XRayClient ⇒ A): Kleisli[M, XRayClient, A] = interpreter.primitive(f)
  }

  trait AccessAnalyzerInterpreter extends AccessAnalyzerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AccessAnalyzerClient, A] = interpreter.embed(e)
  }

  trait AcmInterpreter extends AcmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AcmClient, A] = interpreter.embed(e)
  }

  trait AcmPcaInterpreter extends AcmPcaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AcmPcaClient, A] = interpreter.embed(e)
  }

  trait AlexaForBusinessInterpreter extends AlexaForBusinessOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AlexaForBusinessClient, A] = interpreter.embed(e)
  }

  trait AmpInterpreter extends AmpOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AmpClient, A] = interpreter.embed(e)
  }

  trait AmplifyInterpreter extends AmplifyOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AmplifyClient, A] = interpreter.embed(e)
  }

  trait AmplifyBackendInterpreter extends AmplifyBackendOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AmplifyBackendClient, A] = interpreter.embed(e)
  }

  trait ApiGatewayInterpreter extends ApiGatewayOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApiGatewayClient, A] = interpreter.embed(e)
  }

  trait ApiGatewayManagementApiInterpreter extends ApiGatewayManagementApiOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApiGatewayManagementApiClient, A] = interpreter.embed(e)
  }

  trait ApiGatewayV2Interpreter extends ApiGatewayV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApiGatewayV2Client, A] = interpreter.embed(e)
  }

  trait AppConfigInterpreter extends AppConfigOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppConfigClient, A] = interpreter.embed(e)
  }

  trait AppIntegrationsInterpreter extends AppIntegrationsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppIntegrationsClient, A] = interpreter.embed(e)
  }

  trait AppMeshInterpreter extends AppMeshOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppMeshClient, A] = interpreter.embed(e)
  }

  trait AppRunnerInterpreter extends AppRunnerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppRunnerClient, A] = interpreter.embed(e)
  }

  trait AppStreamInterpreter extends AppStreamOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppStreamClient, A] = interpreter.embed(e)
  }

  trait AppSyncInterpreter extends AppSyncOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppSyncClient, A] = interpreter.embed(e)
  }

  trait AppflowInterpreter extends AppflowOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AppflowClient, A] = interpreter.embed(e)
  }

  trait ApplicationAutoScalingInterpreter extends ApplicationAutoScalingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApplicationAutoScalingClient, A] = interpreter.embed(e)
  }

  trait ApplicationCostProfilerInterpreter extends ApplicationCostProfilerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApplicationCostProfilerClient, A] = interpreter.embed(e)
  }

  trait ApplicationDiscoveryInterpreter extends ApplicationDiscoveryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApplicationDiscoveryClient, A] = interpreter.embed(e)
  }

  trait ApplicationInsightsInterpreter extends ApplicationInsightsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ApplicationInsightsClient, A] = interpreter.embed(e)
  }

  trait AthenaInterpreter extends AthenaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AthenaClient, A] = interpreter.embed(e)
  }

  trait AuditManagerInterpreter extends AuditManagerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AuditManagerClient, A] = interpreter.embed(e)
  }

  trait AutoScalingInterpreter extends AutoScalingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AutoScalingClient, A] = interpreter.embed(e)
  }

  trait AutoScalingPlansInterpreter extends AutoScalingPlansOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, AutoScalingPlansClient, A] = interpreter.embed(e)
  }

  trait BackupInterpreter extends BackupOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, BackupClient, A] = interpreter.embed(e)
  }

  trait BatchInterpreter extends BatchOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, BatchClient, A] = interpreter.embed(e)
  }

  trait BraketInterpreter extends BraketOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, BraketClient, A] = interpreter.embed(e)
  }

  trait BudgetsInterpreter extends BudgetsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, BudgetsClient, A] = interpreter.embed(e)
  }

  trait ChimeInterpreter extends ChimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ChimeClient, A] = interpreter.embed(e)
  }

  trait Cloud9Interpreter extends Cloud9Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Cloud9Client, A] = interpreter.embed(e)
  }

  trait CloudDirectoryInterpreter extends CloudDirectoryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudDirectoryClient, A] = interpreter.embed(e)
  }

  trait CloudFormationInterpreter extends CloudFormationOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudFormationClient, A] = interpreter.embed(e)
  }

  trait CloudFrontInterpreter extends CloudFrontOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudFrontClient, A] = interpreter.embed(e)
  }

  trait CloudHsmInterpreter extends CloudHsmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudHsmClient, A] = interpreter.embed(e)
  }

  trait CloudHsmV2Interpreter extends CloudHsmV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudHsmV2Client, A] = interpreter.embed(e)
  }

  trait CloudSearchInterpreter extends CloudSearchOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudSearchClient, A] = interpreter.embed(e)
  }

  trait CloudSearchDomainInterpreter extends CloudSearchDomainOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudSearchDomainClient, A] = interpreter.embed(e)
  }

  trait CloudTrailInterpreter extends CloudTrailOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudTrailClient, A] = interpreter.embed(e)
  }

  trait CloudWatchInterpreter extends CloudWatchOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudWatchClient, A] = interpreter.embed(e)
  }

  trait CloudWatchEventsInterpreter extends CloudWatchEventsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudWatchEventsClient, A] = interpreter.embed(e)
  }

  trait CloudWatchLogsInterpreter extends CloudWatchLogsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CloudWatchLogsClient, A] = interpreter.embed(e)
  }

  trait CodeBuildInterpreter extends CodeBuildOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeBuildClient, A] = interpreter.embed(e)
  }

  trait CodeCommitInterpreter extends CodeCommitOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeCommitClient, A] = interpreter.embed(e)
  }

  trait CodeDeployInterpreter extends CodeDeployOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeDeployClient, A] = interpreter.embed(e)
  }

  trait CodeGuruProfilerInterpreter extends CodeGuruProfilerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeGuruProfilerClient, A] = interpreter.embed(e)
  }

  trait CodeGuruReviewerInterpreter extends CodeGuruReviewerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeGuruReviewerClient, A] = interpreter.embed(e)
  }

  trait CodePipelineInterpreter extends CodePipelineOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodePipelineClient, A] = interpreter.embed(e)
  }

  trait CodeStarInterpreter extends CodeStarOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeStarClient, A] = interpreter.embed(e)
  }

  trait CodeStarConnectionsInterpreter extends CodeStarConnectionsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeStarConnectionsClient, A] = interpreter.embed(e)
  }

  trait CodeartifactInterpreter extends CodeartifactOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodeartifactClient, A] = interpreter.embed(e)
  }

  trait CodestarNotificationsInterpreter extends CodestarNotificationsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CodestarNotificationsClient, A] = interpreter.embed(e)
  }

  trait CognitoIdentityInterpreter extends CognitoIdentityOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CognitoIdentityClient, A] = interpreter.embed(e)
  }

  trait CognitoIdentityProviderInterpreter extends CognitoIdentityProviderOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CognitoIdentityProviderClient, A] = interpreter.embed(e)
  }

  trait CognitoSyncInterpreter extends CognitoSyncOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CognitoSyncClient, A] = interpreter.embed(e)
  }

  trait ComprehendInterpreter extends ComprehendOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ComprehendClient, A] = interpreter.embed(e)
  }

  trait ComprehendMedicalInterpreter extends ComprehendMedicalOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ComprehendMedicalClient, A] = interpreter.embed(e)
  }

  trait ComputeOptimizerInterpreter extends ComputeOptimizerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ComputeOptimizerClient, A] = interpreter.embed(e)
  }

  trait ConfigInterpreter extends ConfigOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ConfigClient, A] = interpreter.embed(e)
  }

  trait ConnectInterpreter extends ConnectOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ConnectClient, A] = interpreter.embed(e)
  }

  trait ConnectContactLensInterpreter extends ConnectContactLensOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ConnectContactLensClient, A] = interpreter.embed(e)
  }

  trait ConnectParticipantInterpreter extends ConnectParticipantOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ConnectParticipantClient, A] = interpreter.embed(e)
  }

  trait CostAndUsageReportInterpreter extends CostAndUsageReportOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CostAndUsageReportClient, A] = interpreter.embed(e)
  }

  trait CostExplorerInterpreter extends CostExplorerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CostExplorerClient, A] = interpreter.embed(e)
  }

  trait CustomerProfilesInterpreter extends CustomerProfilesOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, CustomerProfilesClient, A] = interpreter.embed(e)
  }

  trait DataBrewInterpreter extends DataBrewOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DataBrewClient, A] = interpreter.embed(e)
  }

  trait DataExchangeInterpreter extends DataExchangeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DataExchangeClient, A] = interpreter.embed(e)
  }

  trait DataPipelineInterpreter extends DataPipelineOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DataPipelineClient, A] = interpreter.embed(e)
  }

  trait DataSyncInterpreter extends DataSyncOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DataSyncClient, A] = interpreter.embed(e)
  }

  trait DatabaseMigrationInterpreter extends DatabaseMigrationOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DatabaseMigrationClient, A] = interpreter.embed(e)
  }

  trait DaxInterpreter extends DaxOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DaxClient, A] = interpreter.embed(e)
  }

  trait DetectiveInterpreter extends DetectiveOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DetectiveClient, A] = interpreter.embed(e)
  }

  trait DevOpsGuruInterpreter extends DevOpsGuruOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DevOpsGuruClient, A] = interpreter.embed(e)
  }

  trait DeviceFarmInterpreter extends DeviceFarmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DeviceFarmClient, A] = interpreter.embed(e)
  }

  trait DirectConnectInterpreter extends DirectConnectOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DirectConnectClient, A] = interpreter.embed(e)
  }

  trait DirectoryInterpreter extends DirectoryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DirectoryClient, A] = interpreter.embed(e)
  }

  trait DlmInterpreter extends DlmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DlmClient, A] = interpreter.embed(e)
  }

  trait DocDbInterpreter extends DocDbOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DocDbClient, A] = interpreter.embed(e)
  }

  trait DynamoDbInterpreter extends DynamoDbOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DynamoDbClient, A] = interpreter.embed(e)
  }

  trait DynamoDbStreamsInterpreter extends DynamoDbStreamsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, DynamoDbStreamsClient, A] = interpreter.embed(e)
  }

  trait EbsInterpreter extends EbsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EbsClient, A] = interpreter.embed(e)
  }

  trait Ec2Interpreter extends Ec2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Ec2Client, A] = interpreter.embed(e)
  }

  trait Ec2InstanceConnectInterpreter extends Ec2InstanceConnectOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Ec2InstanceConnectClient, A] = interpreter.embed(e)
  }

  trait EcrInterpreter extends EcrOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EcrClient, A] = interpreter.embed(e)
  }

  trait EcrPublicInterpreter extends EcrPublicOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EcrPublicClient, A] = interpreter.embed(e)
  }

  trait EcsInterpreter extends EcsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EcsClient, A] = interpreter.embed(e)
  }

  trait EfsInterpreter extends EfsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EfsClient, A] = interpreter.embed(e)
  }

  trait EksInterpreter extends EksOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EksClient, A] = interpreter.embed(e)
  }

  trait ElastiCacheInterpreter extends ElastiCacheOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElastiCacheClient, A] = interpreter.embed(e)
  }

  trait ElasticBeanstalkInterpreter extends ElasticBeanstalkOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticBeanstalkClient, A] = interpreter.embed(e)
  }

  trait ElasticInferenceInterpreter extends ElasticInferenceOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticInferenceClient, A] = interpreter.embed(e)
  }

  trait ElasticLoadBalancingInterpreter extends ElasticLoadBalancingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticLoadBalancingClient, A] = interpreter.embed(e)
  }

  trait ElasticLoadBalancingV2Interpreter extends ElasticLoadBalancingV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticLoadBalancingV2Client, A] = interpreter.embed(e)
  }

  trait ElasticTranscoderInterpreter extends ElasticTranscoderOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticTranscoderClient, A] = interpreter.embed(e)
  }

  trait ElasticsearchInterpreter extends ElasticsearchOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ElasticsearchClient, A] = interpreter.embed(e)
  }

  trait EmrInterpreter extends EmrOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EmrClient, A] = interpreter.embed(e)
  }

  trait EmrContainersInterpreter extends EmrContainersOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EmrContainersClient, A] = interpreter.embed(e)
  }

  trait EventBridgeInterpreter extends EventBridgeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, EventBridgeClient, A] = interpreter.embed(e)
  }

  trait FSxInterpreter extends FSxOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FSxClient, A] = interpreter.embed(e)
  }

  trait FinspaceInterpreter extends FinspaceOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FinspaceClient, A] = interpreter.embed(e)
  }

  trait FinspaceDataInterpreter extends FinspaceDataOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FinspaceDataClient, A] = interpreter.embed(e)
  }

  trait FirehoseInterpreter extends FirehoseOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FirehoseClient, A] = interpreter.embed(e)
  }

  trait FisInterpreter extends FisOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FisClient, A] = interpreter.embed(e)
  }

  trait FmsInterpreter extends FmsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FmsClient, A] = interpreter.embed(e)
  }

  trait ForecastInterpreter extends ForecastOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ForecastClient, A] = interpreter.embed(e)
  }

  trait ForecastqueryInterpreter extends ForecastqueryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ForecastqueryClient, A] = interpreter.embed(e)
  }

  trait FraudDetectorInterpreter extends FraudDetectorOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, FraudDetectorClient, A] = interpreter.embed(e)
  }

  trait GameLiftInterpreter extends GameLiftOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GameLiftClient, A] = interpreter.embed(e)
  }

  trait GlacierInterpreter extends GlacierOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GlacierClient, A] = interpreter.embed(e)
  }

  trait GlobalAcceleratorInterpreter extends GlobalAcceleratorOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GlobalAcceleratorClient, A] = interpreter.embed(e)
  }

  trait GlueInterpreter extends GlueOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GlueClient, A] = interpreter.embed(e)
  }

  trait GreengrassInterpreter extends GreengrassOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GreengrassClient, A] = interpreter.embed(e)
  }

  trait GreengrassV2Interpreter extends GreengrassV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GreengrassV2Client, A] = interpreter.embed(e)
  }

  trait GroundStationInterpreter extends GroundStationOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GroundStationClient, A] = interpreter.embed(e)
  }

  trait GuardDutyInterpreter extends GuardDutyOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, GuardDutyClient, A] = interpreter.embed(e)
  }

  trait HealthInterpreter extends HealthOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, HealthClient, A] = interpreter.embed(e)
  }

  trait HealthLakeInterpreter extends HealthLakeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, HealthLakeClient, A] = interpreter.embed(e)
  }

  trait HoneycodeInterpreter extends HoneycodeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, HoneycodeClient, A] = interpreter.embed(e)
  }

  trait IamInterpreter extends IamOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IamClient, A] = interpreter.embed(e)
  }

  trait IdentitystoreInterpreter extends IdentitystoreOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IdentitystoreClient, A] = interpreter.embed(e)
  }

  trait ImagebuilderInterpreter extends ImagebuilderOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ImagebuilderClient, A] = interpreter.embed(e)
  }

  trait InspectorInterpreter extends InspectorOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, InspectorClient, A] = interpreter.embed(e)
  }

  trait IoTAnalyticsInterpreter extends IoTAnalyticsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IoTAnalyticsClient, A] = interpreter.embed(e)
  }

  trait IoTFleetHubInterpreter extends IoTFleetHubOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IoTFleetHubClient, A] = interpreter.embed(e)
  }

  trait IoTSecureTunnelingInterpreter extends IoTSecureTunnelingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IoTSecureTunnelingClient, A] = interpreter.embed(e)
  }

  trait IoTSiteWiseInterpreter extends IoTSiteWiseOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IoTSiteWiseClient, A] = interpreter.embed(e)
  }

  trait IoTThingsGraphInterpreter extends IoTThingsGraphOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IoTThingsGraphClient, A] = interpreter.embed(e)
  }

  trait IotInterpreter extends IotOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotClient, A] = interpreter.embed(e)
  }

  trait Iot1ClickDevicesInterpreter extends Iot1ClickDevicesOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Iot1ClickDevicesClient, A] = interpreter.embed(e)
  }

  trait Iot1ClickProjectsInterpreter extends Iot1ClickProjectsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Iot1ClickProjectsClient, A] = interpreter.embed(e)
  }

  trait IotDataPlaneInterpreter extends IotDataPlaneOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotDataPlaneClient, A] = interpreter.embed(e)
  }

  trait IotDeviceAdvisorInterpreter extends IotDeviceAdvisorOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotDeviceAdvisorClient, A] = interpreter.embed(e)
  }

  trait IotEventsInterpreter extends IotEventsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotEventsClient, A] = interpreter.embed(e)
  }

  trait IotEventsDataInterpreter extends IotEventsDataOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotEventsDataClient, A] = interpreter.embed(e)
  }

  trait IotJobsDataPlaneInterpreter extends IotJobsDataPlaneOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotJobsDataPlaneClient, A] = interpreter.embed(e)
  }

  trait IotWirelessInterpreter extends IotWirelessOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IotWirelessClient, A] = interpreter.embed(e)
  }

  trait IvsInterpreter extends IvsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, IvsClient, A] = interpreter.embed(e)
  }

  trait KafkaInterpreter extends KafkaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KafkaClient, A] = interpreter.embed(e)
  }

  trait KendraInterpreter extends KendraOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KendraClient, A] = interpreter.embed(e)
  }

  trait KinesisInterpreter extends KinesisOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisClient, A] = interpreter.embed(e)
  }

  trait KinesisAnalyticsInterpreter extends KinesisAnalyticsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisAnalyticsClient, A] = interpreter.embed(e)
  }

  trait KinesisAnalyticsV2Interpreter extends KinesisAnalyticsV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisAnalyticsV2Client, A] = interpreter.embed(e)
  }

  trait KinesisVideoInterpreter extends KinesisVideoOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisVideoClient, A] = interpreter.embed(e)
  }

  trait KinesisVideoArchivedMediaInterpreter extends KinesisVideoArchivedMediaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisVideoArchivedMediaClient, A] = interpreter.embed(e)
  }

  trait KinesisVideoMediaInterpreter extends KinesisVideoMediaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisVideoMediaClient, A] = interpreter.embed(e)
  }

  trait KinesisVideoSignalingInterpreter extends KinesisVideoSignalingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KinesisVideoSignalingClient, A] = interpreter.embed(e)
  }

  trait KmsInterpreter extends KmsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, KmsClient, A] = interpreter.embed(e)
  }

  trait LakeFormationInterpreter extends LakeFormationOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LakeFormationClient, A] = interpreter.embed(e)
  }

  trait LambdaInterpreter extends LambdaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LambdaClient, A] = interpreter.embed(e)
  }

  trait LexModelBuildingInterpreter extends LexModelBuildingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LexModelBuildingClient, A] = interpreter.embed(e)
  }

  trait LexModelsV2Interpreter extends LexModelsV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LexModelsV2Client, A] = interpreter.embed(e)
  }

  trait LexRuntimeInterpreter extends LexRuntimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LexRuntimeClient, A] = interpreter.embed(e)
  }

  trait LexRuntimeV2Interpreter extends LexRuntimeV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LexRuntimeV2Client, A] = interpreter.embed(e)
  }

  trait LicenseManagerInterpreter extends LicenseManagerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LicenseManagerClient, A] = interpreter.embed(e)
  }

  trait LightsailInterpreter extends LightsailOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LightsailClient, A] = interpreter.embed(e)
  }

  trait LocationInterpreter extends LocationOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LocationClient, A] = interpreter.embed(e)
  }

  trait LookoutEquipmentInterpreter extends LookoutEquipmentOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LookoutEquipmentClient, A] = interpreter.embed(e)
  }

  trait LookoutMetricsInterpreter extends LookoutMetricsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LookoutMetricsClient, A] = interpreter.embed(e)
  }

  trait LookoutVisionInterpreter extends LookoutVisionOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, LookoutVisionClient, A] = interpreter.embed(e)
  }

  trait MTurkInterpreter extends MTurkOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MTurkClient, A] = interpreter.embed(e)
  }

  trait MachineLearningInterpreter extends MachineLearningOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MachineLearningClient, A] = interpreter.embed(e)
  }

  trait MacieInterpreter extends MacieOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MacieClient, A] = interpreter.embed(e)
  }

  trait Macie2Interpreter extends Macie2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Macie2Client, A] = interpreter.embed(e)
  }

  trait ManagedBlockchainInterpreter extends ManagedBlockchainOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ManagedBlockchainClient, A] = interpreter.embed(e)
  }

  trait MarketplaceCatalogInterpreter extends MarketplaceCatalogOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MarketplaceCatalogClient, A] = interpreter.embed(e)
  }

  trait MarketplaceCommerceAnalyticsInterpreter extends MarketplaceCommerceAnalyticsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MarketplaceCommerceAnalyticsClient, A] = interpreter.embed(e)
  }

  trait MarketplaceEntitlementInterpreter extends MarketplaceEntitlementOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MarketplaceEntitlementClient, A] = interpreter.embed(e)
  }

  trait MarketplaceMeteringInterpreter extends MarketplaceMeteringOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MarketplaceMeteringClient, A] = interpreter.embed(e)
  }

  trait MediaConnectInterpreter extends MediaConnectOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaConnectClient, A] = interpreter.embed(e)
  }

  trait MediaConvertInterpreter extends MediaConvertOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaConvertClient, A] = interpreter.embed(e)
  }

  trait MediaLiveInterpreter extends MediaLiveOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaLiveClient, A] = interpreter.embed(e)
  }

  trait MediaPackageInterpreter extends MediaPackageOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaPackageClient, A] = interpreter.embed(e)
  }

  trait MediaPackageVodInterpreter extends MediaPackageVodOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaPackageVodClient, A] = interpreter.embed(e)
  }

  trait MediaStoreInterpreter extends MediaStoreOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaStoreClient, A] = interpreter.embed(e)
  }

  trait MediaStoreDataInterpreter extends MediaStoreDataOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaStoreDataClient, A] = interpreter.embed(e)
  }

  trait MediaTailorInterpreter extends MediaTailorOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MediaTailorClient, A] = interpreter.embed(e)
  }

  trait MgnInterpreter extends MgnOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MgnClient, A] = interpreter.embed(e)
  }

  trait MigrationHubInterpreter extends MigrationHubOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MigrationHubClient, A] = interpreter.embed(e)
  }

  trait MigrationHubConfigInterpreter extends MigrationHubConfigOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MigrationHubConfigClient, A] = interpreter.embed(e)
  }

  trait MobileInterpreter extends MobileOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MobileClient, A] = interpreter.embed(e)
  }

  trait MqInterpreter extends MqOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MqClient, A] = interpreter.embed(e)
  }

  trait MwaaInterpreter extends MwaaOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, MwaaClient, A] = interpreter.embed(e)
  }

  trait NeptuneInterpreter extends NeptuneOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, NeptuneClient, A] = interpreter.embed(e)
  }

  trait NetworkFirewallInterpreter extends NetworkFirewallOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, NetworkFirewallClient, A] = interpreter.embed(e)
  }

  trait NetworkManagerInterpreter extends NetworkManagerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, NetworkManagerClient, A] = interpreter.embed(e)
  }

  trait NimbleInterpreter extends NimbleOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, NimbleClient, A] = interpreter.embed(e)
  }

  trait OpsWorksInterpreter extends OpsWorksOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, OpsWorksClient, A] = interpreter.embed(e)
  }

  trait OpsWorksCmInterpreter extends OpsWorksCmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, OpsWorksCmClient, A] = interpreter.embed(e)
  }

  trait OrganizationsInterpreter extends OrganizationsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, OrganizationsClient, A] = interpreter.embed(e)
  }

  trait OutpostsInterpreter extends OutpostsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, OutpostsClient, A] = interpreter.embed(e)
  }

  trait PersonalizeInterpreter extends PersonalizeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PersonalizeClient, A] = interpreter.embed(e)
  }

  trait PersonalizeEventsInterpreter extends PersonalizeEventsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PersonalizeEventsClient, A] = interpreter.embed(e)
  }

  trait PersonalizeRuntimeInterpreter extends PersonalizeRuntimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PersonalizeRuntimeClient, A] = interpreter.embed(e)
  }

  trait PiInterpreter extends PiOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PiClient, A] = interpreter.embed(e)
  }

  trait PinpointInterpreter extends PinpointOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PinpointClient, A] = interpreter.embed(e)
  }

  trait PinpointEmailInterpreter extends PinpointEmailOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PinpointEmailClient, A] = interpreter.embed(e)
  }

  trait PinpointSmsVoiceInterpreter extends PinpointSmsVoiceOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PinpointSmsVoiceClient, A] = interpreter.embed(e)
  }

  trait PollyInterpreter extends PollyOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PollyClient, A] = interpreter.embed(e)
  }

  trait PricingInterpreter extends PricingOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, PricingClient, A] = interpreter.embed(e)
  }

  trait ProtonInterpreter extends ProtonOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ProtonClient, A] = interpreter.embed(e)
  }

  trait QldbInterpreter extends QldbOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, QldbClient, A] = interpreter.embed(e)
  }

  trait QldbSessionInterpreter extends QldbSessionOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, QldbSessionClient, A] = interpreter.embed(e)
  }

  trait QuickSightInterpreter extends QuickSightOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, QuickSightClient, A] = interpreter.embed(e)
  }

  trait RamInterpreter extends RamOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RamClient, A] = interpreter.embed(e)
  }

  trait RdsInterpreter extends RdsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RdsClient, A] = interpreter.embed(e)
  }

  trait RdsDataInterpreter extends RdsDataOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RdsDataClient, A] = interpreter.embed(e)
  }

  trait RedshiftInterpreter extends RedshiftOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RedshiftClient, A] = interpreter.embed(e)
  }

  trait RedshiftDataInterpreter extends RedshiftDataOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RedshiftDataClient, A] = interpreter.embed(e)
  }

  trait RekognitionInterpreter extends RekognitionOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RekognitionClient, A] = interpreter.embed(e)
  }

  trait ResourceGroupsInterpreter extends ResourceGroupsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ResourceGroupsClient, A] = interpreter.embed(e)
  }

  trait ResourceGroupsTaggingApiInterpreter extends ResourceGroupsTaggingApiOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ResourceGroupsTaggingApiClient, A] = interpreter.embed(e)
  }

  trait RoboMakerInterpreter extends RoboMakerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, RoboMakerClient, A] = interpreter.embed(e)
  }

  trait Route53Interpreter extends Route53Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Route53Client, A] = interpreter.embed(e)
  }

  trait Route53DomainsInterpreter extends Route53DomainsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Route53DomainsClient, A] = interpreter.embed(e)
  }

  trait Route53ResolverInterpreter extends Route53ResolverOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Route53ResolverClient, A] = interpreter.embed(e)
  }

  trait S3Interpreter extends S3Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, S3Client, A] = interpreter.embed(e)
  }

  trait S3ControlInterpreter extends S3ControlOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, S3ControlClient, A] = interpreter.embed(e)
  }

  trait S3OutpostsInterpreter extends S3OutpostsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, S3OutpostsClient, A] = interpreter.embed(e)
  }

  trait SageMakerInterpreter extends SageMakerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SageMakerClient, A] = interpreter.embed(e)
  }

  trait SageMakerA2IRuntimeInterpreter extends SageMakerA2IRuntimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SageMakerA2IRuntimeClient, A] = interpreter.embed(e)
  }

  trait SageMakerFeatureStoreRuntimeInterpreter extends SageMakerFeatureStoreRuntimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SageMakerFeatureStoreRuntimeClient, A] = interpreter.embed(e)
  }

  trait SageMakerRuntimeInterpreter extends SageMakerRuntimeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SageMakerRuntimeClient, A] = interpreter.embed(e)
  }

  trait SagemakerEdgeInterpreter extends SagemakerEdgeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SagemakerEdgeClient, A] = interpreter.embed(e)
  }

  trait SavingsplansInterpreter extends SavingsplansOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SavingsplansClient, A] = interpreter.embed(e)
  }

  trait SchemasInterpreter extends SchemasOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SchemasClient, A] = interpreter.embed(e)
  }

  trait SecretsManagerInterpreter extends SecretsManagerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SecretsManagerClient, A] = interpreter.embed(e)
  }

  trait SecurityHubInterpreter extends SecurityHubOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SecurityHubClient, A] = interpreter.embed(e)
  }

  trait ServerlessApplicationRepositoryInterpreter extends ServerlessApplicationRepositoryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ServerlessApplicationRepositoryClient, A] = interpreter.embed(e)
  }

  trait ServiceCatalogInterpreter extends ServiceCatalogOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ServiceCatalogClient, A] = interpreter.embed(e)
  }

  trait ServiceCatalogAppRegistryInterpreter extends ServiceCatalogAppRegistryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ServiceCatalogAppRegistryClient, A] = interpreter.embed(e)
  }

  trait ServiceDiscoveryInterpreter extends ServiceDiscoveryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ServiceDiscoveryClient, A] = interpreter.embed(e)
  }

  trait ServiceQuotasInterpreter extends ServiceQuotasOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ServiceQuotasClient, A] = interpreter.embed(e)
  }

  trait SesInterpreter extends SesOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SesClient, A] = interpreter.embed(e)
  }

  trait SesV2Interpreter extends SesV2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SesV2Client, A] = interpreter.embed(e)
  }

  trait SfnInterpreter extends SfnOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SfnClient, A] = interpreter.embed(e)
  }

  trait ShieldInterpreter extends ShieldOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, ShieldClient, A] = interpreter.embed(e)
  }

  trait SignerInterpreter extends SignerOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SignerClient, A] = interpreter.embed(e)
  }

  trait SmsInterpreter extends SmsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SmsClient, A] = interpreter.embed(e)
  }

  trait SnowballInterpreter extends SnowballOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SnowballClient, A] = interpreter.embed(e)
  }

  trait SnsInterpreter extends SnsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SnsClient, A] = interpreter.embed(e)
  }

  trait SqsInterpreter extends SqsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SqsClient, A] = interpreter.embed(e)
  }

  trait SsmInterpreter extends SsmOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsmClient, A] = interpreter.embed(e)
  }

  trait SsmContactsInterpreter extends SsmContactsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsmContactsClient, A] = interpreter.embed(e)
  }

  trait SsmIncidentsInterpreter extends SsmIncidentsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsmIncidentsClient, A] = interpreter.embed(e)
  }

  trait SsoInterpreter extends SsoOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsoClient, A] = interpreter.embed(e)
  }

  trait SsoAdminInterpreter extends SsoAdminOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsoAdminClient, A] = interpreter.embed(e)
  }

  trait SsoOidcInterpreter extends SsoOidcOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SsoOidcClient, A] = interpreter.embed(e)
  }

  trait StorageGatewayInterpreter extends StorageGatewayOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, StorageGatewayClient, A] = interpreter.embed(e)
  }

  trait StsInterpreter extends StsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, StsClient, A] = interpreter.embed(e)
  }

  trait SupportInterpreter extends SupportOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SupportClient, A] = interpreter.embed(e)
  }

  trait SwfInterpreter extends SwfOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SwfClient, A] = interpreter.embed(e)
  }

  trait SyntheticsInterpreter extends SyntheticsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, SyntheticsClient, A] = interpreter.embed(e)
  }

  trait TextractInterpreter extends TextractOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TextractClient, A] = interpreter.embed(e)
  }

  trait TimestreamQueryInterpreter extends TimestreamQueryOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TimestreamQueryClient, A] = interpreter.embed(e)
  }

  trait TimestreamWriteInterpreter extends TimestreamWriteOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TimestreamWriteClient, A] = interpreter.embed(e)
  }

  trait TranscribeInterpreter extends TranscribeOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TranscribeClient, A] = interpreter.embed(e)
  }

  trait TransferInterpreter extends TransferOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TransferClient, A] = interpreter.embed(e)
  }

  trait TranslateInterpreter extends TranslateOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, TranslateClient, A] = interpreter.embed(e)
  }

  trait WafInterpreter extends WafOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WafClient, A] = interpreter.embed(e)
  }

  trait WafRegionalInterpreter extends WafRegionalOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WafRegionalClient, A] = interpreter.embed(e)
  }

  trait Wafv2Interpreter extends Wafv2Op.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, Wafv2Client, A] = interpreter.embed(e)
  }

  trait WellArchitectedInterpreter extends WellArchitectedOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WellArchitectedClient, A] = interpreter.embed(e)
  }

  trait WorkDocsInterpreter extends WorkDocsOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WorkDocsClient, A] = interpreter.embed(e)
  }

  trait WorkLinkInterpreter extends WorkLinkOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WorkLinkClient, A] = interpreter.embed(e)
  }

  trait WorkMailInterpreter extends WorkMailOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WorkMailClient, A] = interpreter.embed(e)
  }

  trait WorkMailMessageFlowInterpreter extends WorkMailMessageFlowOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WorkMailMessageFlowClient, A] = interpreter.embed(e)
  }

  trait WorkSpacesInterpreter extends WorkSpacesOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, WorkSpacesClient, A] = interpreter.embed(e)
  }

  trait XRayInterpreter extends XRayOp.Visitor.KleisliVisitor[M] {
    def embed[A](e: Embedded[A]): Kleisli[M, XRayClient, A] = interpreter.embed(e)
  }


  def primitive[J, A](f: J => A): Kleisli[M, J, A] = Kleisli(a => {
    // primitive AWS methods throw exceptions and so do we when reading values
    // so catch any non-fatal exceptions and lift them into the effect
    blocker.blockOn[M, A](try {
      asyncM.delay(f(a))
    } catch {
      case scala.util.control.NonFatal(e) => asyncM.raiseError(e)
    })(contextShiftM)
  })

  def embed[J, A](e: Embedded[A]): Kleisli[M, J, A] = e match {
    case Embedded.AccessAnalyzer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AccessAnalyzerClient, *]](AccessAnalyzerInterpreter).run(client))
    case Embedded.Acm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AcmClient, *]](AcmInterpreter).run(client))
    case Embedded.AcmPca(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AcmPcaClient, *]](AcmPcaInterpreter).run(client))
    case Embedded.AlexaForBusiness(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AlexaForBusinessClient, *]](AlexaForBusinessInterpreter).run(client))
    case Embedded.Amp(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AmpClient, *]](AmpInterpreter).run(client))
    case Embedded.Amplify(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AmplifyClient, *]](AmplifyInterpreter).run(client))
    case Embedded.AmplifyBackend(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AmplifyBackendClient, *]](AmplifyBackendInterpreter).run(client))
    case Embedded.ApiGateway(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApiGatewayClient, *]](ApiGatewayInterpreter).run(client))
    case Embedded.ApiGatewayManagementApi(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApiGatewayManagementApiClient, *]](ApiGatewayManagementApiInterpreter).run(client))
    case Embedded.ApiGatewayV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApiGatewayV2Client, *]](ApiGatewayV2Interpreter).run(client))
    case Embedded.AppConfig(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppConfigClient, *]](AppConfigInterpreter).run(client))
    case Embedded.AppIntegrations(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppIntegrationsClient, *]](AppIntegrationsInterpreter).run(client))
    case Embedded.AppMesh(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppMeshClient, *]](AppMeshInterpreter).run(client))
    case Embedded.AppRunner(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppRunnerClient, *]](AppRunnerInterpreter).run(client))
    case Embedded.AppStream(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppStreamClient, *]](AppStreamInterpreter).run(client))
    case Embedded.AppSync(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppSyncClient, *]](AppSyncInterpreter).run(client))
    case Embedded.Appflow(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AppflowClient, *]](AppflowInterpreter).run(client))
    case Embedded.ApplicationAutoScaling(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApplicationAutoScalingClient, *]](ApplicationAutoScalingInterpreter).run(client))
    case Embedded.ApplicationCostProfiler(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApplicationCostProfilerClient, *]](ApplicationCostProfilerInterpreter).run(client))
    case Embedded.ApplicationDiscovery(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApplicationDiscoveryClient, *]](ApplicationDiscoveryInterpreter).run(client))
    case Embedded.ApplicationInsights(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ApplicationInsightsClient, *]](ApplicationInsightsInterpreter).run(client))
    case Embedded.Athena(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AthenaClient, *]](AthenaInterpreter).run(client))
    case Embedded.AuditManager(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AuditManagerClient, *]](AuditManagerInterpreter).run(client))
    case Embedded.AutoScaling(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AutoScalingClient, *]](AutoScalingInterpreter).run(client))
    case Embedded.AutoScalingPlans(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, AutoScalingPlansClient, *]](AutoScalingPlansInterpreter).run(client))
    case Embedded.Backup(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, BackupClient, *]](BackupInterpreter).run(client))
    case Embedded.Batch(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, BatchClient, *]](BatchInterpreter).run(client))
    case Embedded.Braket(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, BraketClient, *]](BraketInterpreter).run(client))
    case Embedded.Budgets(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, BudgetsClient, *]](BudgetsInterpreter).run(client))
    case Embedded.Chime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ChimeClient, *]](ChimeInterpreter).run(client))
    case Embedded.Cloud9(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Cloud9Client, *]](Cloud9Interpreter).run(client))
    case Embedded.CloudDirectory(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudDirectoryClient, *]](CloudDirectoryInterpreter).run(client))
    case Embedded.CloudFormation(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudFormationClient, *]](CloudFormationInterpreter).run(client))
    case Embedded.CloudFront(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudFrontClient, *]](CloudFrontInterpreter).run(client))
    case Embedded.CloudHsm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudHsmClient, *]](CloudHsmInterpreter).run(client))
    case Embedded.CloudHsmV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudHsmV2Client, *]](CloudHsmV2Interpreter).run(client))
    case Embedded.CloudSearch(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudSearchClient, *]](CloudSearchInterpreter).run(client))
    case Embedded.CloudSearchDomain(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudSearchDomainClient, *]](CloudSearchDomainInterpreter).run(client))
    case Embedded.CloudTrail(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudTrailClient, *]](CloudTrailInterpreter).run(client))
    case Embedded.CloudWatch(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudWatchClient, *]](CloudWatchInterpreter).run(client))
    case Embedded.CloudWatchEvents(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudWatchEventsClient, *]](CloudWatchEventsInterpreter).run(client))
    case Embedded.CloudWatchLogs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CloudWatchLogsClient, *]](CloudWatchLogsInterpreter).run(client))
    case Embedded.CodeBuild(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeBuildClient, *]](CodeBuildInterpreter).run(client))
    case Embedded.CodeCommit(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeCommitClient, *]](CodeCommitInterpreter).run(client))
    case Embedded.CodeDeploy(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeDeployClient, *]](CodeDeployInterpreter).run(client))
    case Embedded.CodeGuruProfiler(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeGuruProfilerClient, *]](CodeGuruProfilerInterpreter).run(client))
    case Embedded.CodeGuruReviewer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeGuruReviewerClient, *]](CodeGuruReviewerInterpreter).run(client))
    case Embedded.CodePipeline(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodePipelineClient, *]](CodePipelineInterpreter).run(client))
    case Embedded.CodeStar(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeStarClient, *]](CodeStarInterpreter).run(client))
    case Embedded.CodeStarConnections(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeStarConnectionsClient, *]](CodeStarConnectionsInterpreter).run(client))
    case Embedded.Codeartifact(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodeartifactClient, *]](CodeartifactInterpreter).run(client))
    case Embedded.CodestarNotifications(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CodestarNotificationsClient, *]](CodestarNotificationsInterpreter).run(client))
    case Embedded.CognitoIdentity(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CognitoIdentityClient, *]](CognitoIdentityInterpreter).run(client))
    case Embedded.CognitoIdentityProvider(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CognitoIdentityProviderClient, *]](CognitoIdentityProviderInterpreter).run(client))
    case Embedded.CognitoSync(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CognitoSyncClient, *]](CognitoSyncInterpreter).run(client))
    case Embedded.Comprehend(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ComprehendClient, *]](ComprehendInterpreter).run(client))
    case Embedded.ComprehendMedical(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ComprehendMedicalClient, *]](ComprehendMedicalInterpreter).run(client))
    case Embedded.ComputeOptimizer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ComputeOptimizerClient, *]](ComputeOptimizerInterpreter).run(client))
    case Embedded.Config(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ConfigClient, *]](ConfigInterpreter).run(client))
    case Embedded.Connect(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ConnectClient, *]](ConnectInterpreter).run(client))
    case Embedded.ConnectContactLens(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ConnectContactLensClient, *]](ConnectContactLensInterpreter).run(client))
    case Embedded.ConnectParticipant(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ConnectParticipantClient, *]](ConnectParticipantInterpreter).run(client))
    case Embedded.CostAndUsageReport(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CostAndUsageReportClient, *]](CostAndUsageReportInterpreter).run(client))
    case Embedded.CostExplorer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CostExplorerClient, *]](CostExplorerInterpreter).run(client))
    case Embedded.CustomerProfiles(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, CustomerProfilesClient, *]](CustomerProfilesInterpreter).run(client))
    case Embedded.DataBrew(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DataBrewClient, *]](DataBrewInterpreter).run(client))
    case Embedded.DataExchange(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DataExchangeClient, *]](DataExchangeInterpreter).run(client))
    case Embedded.DataPipeline(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DataPipelineClient, *]](DataPipelineInterpreter).run(client))
    case Embedded.DataSync(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DataSyncClient, *]](DataSyncInterpreter).run(client))
    case Embedded.DatabaseMigration(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DatabaseMigrationClient, *]](DatabaseMigrationInterpreter).run(client))
    case Embedded.Dax(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DaxClient, *]](DaxInterpreter).run(client))
    case Embedded.Detective(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DetectiveClient, *]](DetectiveInterpreter).run(client))
    case Embedded.DevOpsGuru(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DevOpsGuruClient, *]](DevOpsGuruInterpreter).run(client))
    case Embedded.DeviceFarm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DeviceFarmClient, *]](DeviceFarmInterpreter).run(client))
    case Embedded.DirectConnect(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DirectConnectClient, *]](DirectConnectInterpreter).run(client))
    case Embedded.Directory(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DirectoryClient, *]](DirectoryInterpreter).run(client))
    case Embedded.Dlm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DlmClient, *]](DlmInterpreter).run(client))
    case Embedded.DocDb(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DocDbClient, *]](DocDbInterpreter).run(client))
    case Embedded.DynamoDb(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DynamoDbClient, *]](DynamoDbInterpreter).run(client))
    case Embedded.DynamoDbStreams(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, DynamoDbStreamsClient, *]](DynamoDbStreamsInterpreter).run(client))
    case Embedded.Ebs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EbsClient, *]](EbsInterpreter).run(client))
    case Embedded.Ec2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Ec2Client, *]](Ec2Interpreter).run(client))
    case Embedded.Ec2InstanceConnect(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Ec2InstanceConnectClient, *]](Ec2InstanceConnectInterpreter).run(client))
    case Embedded.Ecr(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EcrClient, *]](EcrInterpreter).run(client))
    case Embedded.EcrPublic(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EcrPublicClient, *]](EcrPublicInterpreter).run(client))
    case Embedded.Ecs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EcsClient, *]](EcsInterpreter).run(client))
    case Embedded.Efs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EfsClient, *]](EfsInterpreter).run(client))
    case Embedded.Eks(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EksClient, *]](EksInterpreter).run(client))
    case Embedded.ElastiCache(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElastiCacheClient, *]](ElastiCacheInterpreter).run(client))
    case Embedded.ElasticBeanstalk(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticBeanstalkClient, *]](ElasticBeanstalkInterpreter).run(client))
    case Embedded.ElasticInference(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticInferenceClient, *]](ElasticInferenceInterpreter).run(client))
    case Embedded.ElasticLoadBalancing(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticLoadBalancingClient, *]](ElasticLoadBalancingInterpreter).run(client))
    case Embedded.ElasticLoadBalancingV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticLoadBalancingV2Client, *]](ElasticLoadBalancingV2Interpreter).run(client))
    case Embedded.ElasticTranscoder(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticTranscoderClient, *]](ElasticTranscoderInterpreter).run(client))
    case Embedded.Elasticsearch(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ElasticsearchClient, *]](ElasticsearchInterpreter).run(client))
    case Embedded.Emr(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EmrClient, *]](EmrInterpreter).run(client))
    case Embedded.EmrContainers(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EmrContainersClient, *]](EmrContainersInterpreter).run(client))
    case Embedded.EventBridge(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, EventBridgeClient, *]](EventBridgeInterpreter).run(client))
    case Embedded.FSx(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FSxClient, *]](FSxInterpreter).run(client))
    case Embedded.Finspace(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FinspaceClient, *]](FinspaceInterpreter).run(client))
    case Embedded.FinspaceData(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FinspaceDataClient, *]](FinspaceDataInterpreter).run(client))
    case Embedded.Firehose(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FirehoseClient, *]](FirehoseInterpreter).run(client))
    case Embedded.Fis(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FisClient, *]](FisInterpreter).run(client))
    case Embedded.Fms(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FmsClient, *]](FmsInterpreter).run(client))
    case Embedded.Forecast(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ForecastClient, *]](ForecastInterpreter).run(client))
    case Embedded.Forecastquery(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ForecastqueryClient, *]](ForecastqueryInterpreter).run(client))
    case Embedded.FraudDetector(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, FraudDetectorClient, *]](FraudDetectorInterpreter).run(client))
    case Embedded.GameLift(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GameLiftClient, *]](GameLiftInterpreter).run(client))
    case Embedded.Glacier(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GlacierClient, *]](GlacierInterpreter).run(client))
    case Embedded.GlobalAccelerator(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GlobalAcceleratorClient, *]](GlobalAcceleratorInterpreter).run(client))
    case Embedded.Glue(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GlueClient, *]](GlueInterpreter).run(client))
    case Embedded.Greengrass(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GreengrassClient, *]](GreengrassInterpreter).run(client))
    case Embedded.GreengrassV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GreengrassV2Client, *]](GreengrassV2Interpreter).run(client))
    case Embedded.GroundStation(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GroundStationClient, *]](GroundStationInterpreter).run(client))
    case Embedded.GuardDuty(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, GuardDutyClient, *]](GuardDutyInterpreter).run(client))
    case Embedded.Health(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, HealthClient, *]](HealthInterpreter).run(client))
    case Embedded.HealthLake(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, HealthLakeClient, *]](HealthLakeInterpreter).run(client))
    case Embedded.Honeycode(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, HoneycodeClient, *]](HoneycodeInterpreter).run(client))
    case Embedded.Iam(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IamClient, *]](IamInterpreter).run(client))
    case Embedded.Identitystore(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IdentitystoreClient, *]](IdentitystoreInterpreter).run(client))
    case Embedded.Imagebuilder(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ImagebuilderClient, *]](ImagebuilderInterpreter).run(client))
    case Embedded.Inspector(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, InspectorClient, *]](InspectorInterpreter).run(client))
    case Embedded.IoTAnalytics(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IoTAnalyticsClient, *]](IoTAnalyticsInterpreter).run(client))
    case Embedded.IoTFleetHub(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IoTFleetHubClient, *]](IoTFleetHubInterpreter).run(client))
    case Embedded.IoTSecureTunneling(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IoTSecureTunnelingClient, *]](IoTSecureTunnelingInterpreter).run(client))
    case Embedded.IoTSiteWise(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IoTSiteWiseClient, *]](IoTSiteWiseInterpreter).run(client))
    case Embedded.IoTThingsGraph(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IoTThingsGraphClient, *]](IoTThingsGraphInterpreter).run(client))
    case Embedded.Iot(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotClient, *]](IotInterpreter).run(client))
    case Embedded.Iot1ClickDevices(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Iot1ClickDevicesClient, *]](Iot1ClickDevicesInterpreter).run(client))
    case Embedded.Iot1ClickProjects(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Iot1ClickProjectsClient, *]](Iot1ClickProjectsInterpreter).run(client))
    case Embedded.IotDataPlane(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotDataPlaneClient, *]](IotDataPlaneInterpreter).run(client))
    case Embedded.IotDeviceAdvisor(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotDeviceAdvisorClient, *]](IotDeviceAdvisorInterpreter).run(client))
    case Embedded.IotEvents(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotEventsClient, *]](IotEventsInterpreter).run(client))
    case Embedded.IotEventsData(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotEventsDataClient, *]](IotEventsDataInterpreter).run(client))
    case Embedded.IotJobsDataPlane(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotJobsDataPlaneClient, *]](IotJobsDataPlaneInterpreter).run(client))
    case Embedded.IotWireless(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IotWirelessClient, *]](IotWirelessInterpreter).run(client))
    case Embedded.Ivs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, IvsClient, *]](IvsInterpreter).run(client))
    case Embedded.Kafka(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KafkaClient, *]](KafkaInterpreter).run(client))
    case Embedded.Kendra(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KendraClient, *]](KendraInterpreter).run(client))
    case Embedded.Kinesis(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisClient, *]](KinesisInterpreter).run(client))
    case Embedded.KinesisAnalytics(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisAnalyticsClient, *]](KinesisAnalyticsInterpreter).run(client))
    case Embedded.KinesisAnalyticsV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisAnalyticsV2Client, *]](KinesisAnalyticsV2Interpreter).run(client))
    case Embedded.KinesisVideo(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisVideoClient, *]](KinesisVideoInterpreter).run(client))
    case Embedded.KinesisVideoArchivedMedia(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisVideoArchivedMediaClient, *]](KinesisVideoArchivedMediaInterpreter).run(client))
    case Embedded.KinesisVideoMedia(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisVideoMediaClient, *]](KinesisVideoMediaInterpreter).run(client))
    case Embedded.KinesisVideoSignaling(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KinesisVideoSignalingClient, *]](KinesisVideoSignalingInterpreter).run(client))
    case Embedded.Kms(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, KmsClient, *]](KmsInterpreter).run(client))
    case Embedded.LakeFormation(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LakeFormationClient, *]](LakeFormationInterpreter).run(client))
    case Embedded.Lambda(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LambdaClient, *]](LambdaInterpreter).run(client))
    case Embedded.LexModelBuilding(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LexModelBuildingClient, *]](LexModelBuildingInterpreter).run(client))
    case Embedded.LexModelsV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LexModelsV2Client, *]](LexModelsV2Interpreter).run(client))
    case Embedded.LexRuntime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LexRuntimeClient, *]](LexRuntimeInterpreter).run(client))
    case Embedded.LexRuntimeV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LexRuntimeV2Client, *]](LexRuntimeV2Interpreter).run(client))
    case Embedded.LicenseManager(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LicenseManagerClient, *]](LicenseManagerInterpreter).run(client))
    case Embedded.Lightsail(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LightsailClient, *]](LightsailInterpreter).run(client))
    case Embedded.Location(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LocationClient, *]](LocationInterpreter).run(client))
    case Embedded.LookoutEquipment(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LookoutEquipmentClient, *]](LookoutEquipmentInterpreter).run(client))
    case Embedded.LookoutMetrics(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LookoutMetricsClient, *]](LookoutMetricsInterpreter).run(client))
    case Embedded.LookoutVision(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, LookoutVisionClient, *]](LookoutVisionInterpreter).run(client))
    case Embedded.MTurk(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MTurkClient, *]](MTurkInterpreter).run(client))
    case Embedded.MachineLearning(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MachineLearningClient, *]](MachineLearningInterpreter).run(client))
    case Embedded.Macie(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MacieClient, *]](MacieInterpreter).run(client))
    case Embedded.Macie2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Macie2Client, *]](Macie2Interpreter).run(client))
    case Embedded.ManagedBlockchain(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ManagedBlockchainClient, *]](ManagedBlockchainInterpreter).run(client))
    case Embedded.MarketplaceCatalog(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MarketplaceCatalogClient, *]](MarketplaceCatalogInterpreter).run(client))
    case Embedded.MarketplaceCommerceAnalytics(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MarketplaceCommerceAnalyticsClient, *]](MarketplaceCommerceAnalyticsInterpreter).run(client))
    case Embedded.MarketplaceEntitlement(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MarketplaceEntitlementClient, *]](MarketplaceEntitlementInterpreter).run(client))
    case Embedded.MarketplaceMetering(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MarketplaceMeteringClient, *]](MarketplaceMeteringInterpreter).run(client))
    case Embedded.MediaConnect(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaConnectClient, *]](MediaConnectInterpreter).run(client))
    case Embedded.MediaConvert(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaConvertClient, *]](MediaConvertInterpreter).run(client))
    case Embedded.MediaLive(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaLiveClient, *]](MediaLiveInterpreter).run(client))
    case Embedded.MediaPackage(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaPackageClient, *]](MediaPackageInterpreter).run(client))
    case Embedded.MediaPackageVod(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaPackageVodClient, *]](MediaPackageVodInterpreter).run(client))
    case Embedded.MediaStore(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaStoreClient, *]](MediaStoreInterpreter).run(client))
    case Embedded.MediaStoreData(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaStoreDataClient, *]](MediaStoreDataInterpreter).run(client))
    case Embedded.MediaTailor(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MediaTailorClient, *]](MediaTailorInterpreter).run(client))
    case Embedded.Mgn(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MgnClient, *]](MgnInterpreter).run(client))
    case Embedded.MigrationHub(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MigrationHubClient, *]](MigrationHubInterpreter).run(client))
    case Embedded.MigrationHubConfig(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MigrationHubConfigClient, *]](MigrationHubConfigInterpreter).run(client))
    case Embedded.Mobile(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MobileClient, *]](MobileInterpreter).run(client))
    case Embedded.Mq(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MqClient, *]](MqInterpreter).run(client))
    case Embedded.Mwaa(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, MwaaClient, *]](MwaaInterpreter).run(client))
    case Embedded.Neptune(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, NeptuneClient, *]](NeptuneInterpreter).run(client))
    case Embedded.NetworkFirewall(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, NetworkFirewallClient, *]](NetworkFirewallInterpreter).run(client))
    case Embedded.NetworkManager(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, NetworkManagerClient, *]](NetworkManagerInterpreter).run(client))
    case Embedded.Nimble(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, NimbleClient, *]](NimbleInterpreter).run(client))
    case Embedded.OpsWorks(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, OpsWorksClient, *]](OpsWorksInterpreter).run(client))
    case Embedded.OpsWorksCm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, OpsWorksCmClient, *]](OpsWorksCmInterpreter).run(client))
    case Embedded.Organizations(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, OrganizationsClient, *]](OrganizationsInterpreter).run(client))
    case Embedded.Outposts(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, OutpostsClient, *]](OutpostsInterpreter).run(client))
    case Embedded.Personalize(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PersonalizeClient, *]](PersonalizeInterpreter).run(client))
    case Embedded.PersonalizeEvents(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PersonalizeEventsClient, *]](PersonalizeEventsInterpreter).run(client))
    case Embedded.PersonalizeRuntime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PersonalizeRuntimeClient, *]](PersonalizeRuntimeInterpreter).run(client))
    case Embedded.Pi(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PiClient, *]](PiInterpreter).run(client))
    case Embedded.Pinpoint(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PinpointClient, *]](PinpointInterpreter).run(client))
    case Embedded.PinpointEmail(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PinpointEmailClient, *]](PinpointEmailInterpreter).run(client))
    case Embedded.PinpointSmsVoice(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PinpointSmsVoiceClient, *]](PinpointSmsVoiceInterpreter).run(client))
    case Embedded.Polly(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PollyClient, *]](PollyInterpreter).run(client))
    case Embedded.Pricing(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, PricingClient, *]](PricingInterpreter).run(client))
    case Embedded.Proton(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ProtonClient, *]](ProtonInterpreter).run(client))
    case Embedded.Qldb(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, QldbClient, *]](QldbInterpreter).run(client))
    case Embedded.QldbSession(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, QldbSessionClient, *]](QldbSessionInterpreter).run(client))
    case Embedded.QuickSight(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, QuickSightClient, *]](QuickSightInterpreter).run(client))
    case Embedded.Ram(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RamClient, *]](RamInterpreter).run(client))
    case Embedded.Rds(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RdsClient, *]](RdsInterpreter).run(client))
    case Embedded.RdsData(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RdsDataClient, *]](RdsDataInterpreter).run(client))
    case Embedded.Redshift(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RedshiftClient, *]](RedshiftInterpreter).run(client))
    case Embedded.RedshiftData(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RedshiftDataClient, *]](RedshiftDataInterpreter).run(client))
    case Embedded.Rekognition(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RekognitionClient, *]](RekognitionInterpreter).run(client))
    case Embedded.ResourceGroups(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ResourceGroupsClient, *]](ResourceGroupsInterpreter).run(client))
    case Embedded.ResourceGroupsTaggingApi(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ResourceGroupsTaggingApiClient, *]](ResourceGroupsTaggingApiInterpreter).run(client))
    case Embedded.RoboMaker(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, RoboMakerClient, *]](RoboMakerInterpreter).run(client))
    case Embedded.Route53(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Route53Client, *]](Route53Interpreter).run(client))
    case Embedded.Route53Domains(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Route53DomainsClient, *]](Route53DomainsInterpreter).run(client))
    case Embedded.Route53Resolver(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Route53ResolverClient, *]](Route53ResolverInterpreter).run(client))
    case Embedded.S3(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, S3Client, *]](S3Interpreter).run(client))
    case Embedded.S3Control(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, S3ControlClient, *]](S3ControlInterpreter).run(client))
    case Embedded.S3Outposts(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, S3OutpostsClient, *]](S3OutpostsInterpreter).run(client))
    case Embedded.SageMaker(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SageMakerClient, *]](SageMakerInterpreter).run(client))
    case Embedded.SageMakerA2IRuntime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SageMakerA2IRuntimeClient, *]](SageMakerA2IRuntimeInterpreter).run(client))
    case Embedded.SageMakerFeatureStoreRuntime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SageMakerFeatureStoreRuntimeClient, *]](SageMakerFeatureStoreRuntimeInterpreter).run(client))
    case Embedded.SageMakerRuntime(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SageMakerRuntimeClient, *]](SageMakerRuntimeInterpreter).run(client))
    case Embedded.SagemakerEdge(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SagemakerEdgeClient, *]](SagemakerEdgeInterpreter).run(client))
    case Embedded.Savingsplans(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SavingsplansClient, *]](SavingsplansInterpreter).run(client))
    case Embedded.Schemas(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SchemasClient, *]](SchemasInterpreter).run(client))
    case Embedded.SecretsManager(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SecretsManagerClient, *]](SecretsManagerInterpreter).run(client))
    case Embedded.SecurityHub(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SecurityHubClient, *]](SecurityHubInterpreter).run(client))
    case Embedded.ServerlessApplicationRepository(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ServerlessApplicationRepositoryClient, *]](ServerlessApplicationRepositoryInterpreter).run(client))
    case Embedded.ServiceCatalog(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ServiceCatalogClient, *]](ServiceCatalogInterpreter).run(client))
    case Embedded.ServiceCatalogAppRegistry(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ServiceCatalogAppRegistryClient, *]](ServiceCatalogAppRegistryInterpreter).run(client))
    case Embedded.ServiceDiscovery(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ServiceDiscoveryClient, *]](ServiceDiscoveryInterpreter).run(client))
    case Embedded.ServiceQuotas(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ServiceQuotasClient, *]](ServiceQuotasInterpreter).run(client))
    case Embedded.Ses(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SesClient, *]](SesInterpreter).run(client))
    case Embedded.SesV2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SesV2Client, *]](SesV2Interpreter).run(client))
    case Embedded.Sfn(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SfnClient, *]](SfnInterpreter).run(client))
    case Embedded.Shield(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, ShieldClient, *]](ShieldInterpreter).run(client))
    case Embedded.Signer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SignerClient, *]](SignerInterpreter).run(client))
    case Embedded.Sms(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SmsClient, *]](SmsInterpreter).run(client))
    case Embedded.Snowball(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SnowballClient, *]](SnowballInterpreter).run(client))
    case Embedded.Sns(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SnsClient, *]](SnsInterpreter).run(client))
    case Embedded.Sqs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SqsClient, *]](SqsInterpreter).run(client))
    case Embedded.Ssm(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsmClient, *]](SsmInterpreter).run(client))
    case Embedded.SsmContacts(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsmContactsClient, *]](SsmContactsInterpreter).run(client))
    case Embedded.SsmIncidents(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsmIncidentsClient, *]](SsmIncidentsInterpreter).run(client))
    case Embedded.Sso(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsoClient, *]](SsoInterpreter).run(client))
    case Embedded.SsoAdmin(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsoAdminClient, *]](SsoAdminInterpreter).run(client))
    case Embedded.SsoOidc(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SsoOidcClient, *]](SsoOidcInterpreter).run(client))
    case Embedded.StorageGateway(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, StorageGatewayClient, *]](StorageGatewayInterpreter).run(client))
    case Embedded.Sts(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, StsClient, *]](StsInterpreter).run(client))
    case Embedded.Support(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SupportClient, *]](SupportInterpreter).run(client))
    case Embedded.Swf(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SwfClient, *]](SwfInterpreter).run(client))
    case Embedded.Synthetics(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, SyntheticsClient, *]](SyntheticsInterpreter).run(client))
    case Embedded.Textract(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TextractClient, *]](TextractInterpreter).run(client))
    case Embedded.TimestreamQuery(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TimestreamQueryClient, *]](TimestreamQueryInterpreter).run(client))
    case Embedded.TimestreamWrite(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TimestreamWriteClient, *]](TimestreamWriteInterpreter).run(client))
    case Embedded.Transcribe(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TranscribeClient, *]](TranscribeInterpreter).run(client))
    case Embedded.Transfer(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TransferClient, *]](TransferInterpreter).run(client))
    case Embedded.Translate(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, TranslateClient, *]](TranslateInterpreter).run(client))
    case Embedded.Waf(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WafClient, *]](WafInterpreter).run(client))
    case Embedded.WafRegional(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WafRegionalClient, *]](WafRegionalInterpreter).run(client))
    case Embedded.Wafv2(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, Wafv2Client, *]](Wafv2Interpreter).run(client))
    case Embedded.WellArchitected(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WellArchitectedClient, *]](WellArchitectedInterpreter).run(client))
    case Embedded.WorkDocs(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WorkDocsClient, *]](WorkDocsInterpreter).run(client))
    case Embedded.WorkLink(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WorkLinkClient, *]](WorkLinkInterpreter).run(client))
    case Embedded.WorkMail(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WorkMailClient, *]](WorkMailInterpreter).run(client))
    case Embedded.WorkMailMessageFlow(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WorkMailMessageFlowClient, *]](WorkMailMessageFlowInterpreter).run(client))
    case Embedded.WorkSpaces(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, WorkSpacesClient, *]](WorkSpacesInterpreter).run(client))
    case Embedded.XRay(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, XRayClient, *]](XRayInterpreter).run(client))
  }

  val blocker: Blocker
  implicit val asyncM: Async[M]
  val contextShiftM: ContextShift[M]
}
